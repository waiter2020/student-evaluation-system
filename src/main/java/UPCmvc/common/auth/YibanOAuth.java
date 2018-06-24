package UPCmvc.common.auth;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.dto.VerifyUserInfo;
import UPCmvc.common.dto.YibanBasicUserInfo;
import UPCmvc.common.util.MCrypt;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Service
public class YibanOAuth {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private GetRealMessage getRealMessage;

    public Object dealYibanOauth(String verify_request, String appid, String appkey) {
        MCrypt mCrypt = new MCrypt(appid, appkey);
        String res = null;
        try {
            res = new String(mCrypt.decrypt(verify_request));
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonMes(0, "error parse");
        }
        Gson gson = new Gson();
        try {
            YibanBasicUserInfo yibanBasicUserInfo = gson.fromJson(res, YibanBasicUserInfo.class);
            httpSession.setAttribute("user", yibanBasicUserInfo);

            String access_token = yibanBasicUserInfo.visit_oauth.access_token;
            String message = getRealMessage.getMessage(access_token,"verify_me");

            System.out.println(access_token);
            VerifyUserInfo userInfo = gson.fromJson(message,VerifyUserInfo.class);
            httpSession.setAttribute("realuser",userInfo);

           System.out.println(message);
            System.out.println("授权成功");
            return yibanBasicUserInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JsonMes(0, "error parse");
        }
    }

    public int isAuth(){
        if (httpSession.getAttribute("user")!=null){
            return 1;
        }else {
            return 0;
        }
    }

    public Map dealYibanToken(String verify_request, String appid, String appkey) {
        Map rs = new HashMap();

        MCrypt mCrypt = new MCrypt(appid, appkey);
        String res;
        try {
            res = new String(mCrypt.decrypt(verify_request));
        } catch (Exception e) {
            e.printStackTrace();
            rs.put("status", 1);
            rs.put("errorMsg", "解析Token过程有问题");
            return rs;
        }
        Gson gson = new Gson();
        try {
            Map tokenMap = gson.fromJson(res, Map.class);
            rs.put("status", 0);
            rs.put("data", tokenMap);
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            rs.put("status", 1);
            rs.put("errorMsg", "解析Token过程有问题");
            return rs;
        }
    }
}
