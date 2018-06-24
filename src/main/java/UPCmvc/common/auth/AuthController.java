package UPCmvc.common.auth;

import UPCmvc.common.auth.YibanOAuth;
import UPCmvc.common.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by lylllcc on 2017/5/14.
 */
@RestController
public class AuthController {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private YibanOAuth yibanOAuth;


    @Autowired
    private AuthSuccess authSuccess;


    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public Object doAuth(String vq)   {
        try {
            yibanOAuth.dealYibanOauth(vq, appConfig.appid, appConfig.appkey);
            return authSuccess.getUserInfor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping("/isauth")
    public int isAuth() {
        return yibanOAuth.isAuth();
    }

    @RequestMapping("/logout")
    public int logOut(){
        httpSession.removeAttribute("user");
        httpSession.removeAttribute("realuser");
        return 1;
    }


}
