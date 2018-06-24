package UPCmvc.common.score;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;


@Service
public class GetScore {


    QueryUtil queryUtil = new QueryUtil();

    public ArrayList<ScoreJsonInfo.ScoreInfo> getScoreList(String message){
        Gson gson = new Gson();
        ScoreJsonInfo scoreJsonInfo = gson.fromJson(message, ScoreJsonInfo.class);
        return scoreJsonInfo.Table;
    }

    /**
     * 传入学号,获取成绩json数据
     * @return
     */
    public String getSorceFromWebservice(String studentid) {
        return queryUtil.findStudentScore(studentid);
    }


    public ArrayList<ScoreJsonInfo.ScoreInfo> removeDuplicteScoreMessage(ArrayList<ScoreJsonInfo.ScoreInfo> scoreInfo){
        LinkedHashSet<ScoreJsonInfo.ScoreInfo> s= new LinkedHashSet<ScoreJsonInfo.ScoreInfo>(scoreInfo);
        return new ArrayList<ScoreJsonInfo.ScoreInfo>(s);
    }
}
