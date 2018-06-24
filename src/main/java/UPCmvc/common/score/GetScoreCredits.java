package UPCmvc.common.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lylll on 2017/6/14.
 */

@Service
public class GetScoreCredits {

    @Autowired
    private GetScore getScore;

    public double fivetohun(String five) {
        double zcjd = 0;
        switch (five) {
            case "优秀":
                zcjd = 95;
                break;
            case "良好":
                zcjd = 85;
                break;
            case "中等":
                zcjd = 75;
                break;
            case "及格":
                zcjd = 65;
                break;
            case "不及格":
                zcjd = 40;
                break;
            default:
                zcjd = Integer.valueOf(five);
                break;
        }
        return zcjd;
    }

    public double getScoreCredits(String studentid) {
        ArrayList<ScoreJsonInfo.ScoreInfo> scoreList = getScore.getScoreList(getScore.getSorceFromWebservice(studentid));
        Iterator<ScoreJsonInfo.ScoreInfo> list = scoreList.iterator();
        double xftotal = 0;
        double xfxcj = 0;
        while (list.hasNext()) {
            ScoreJsonInfo.ScoreInfo people = list.next();
            double xf = Integer.valueOf(people.getXF());
            xftotal += Integer.valueOf(people.getXF());
            String zcj = people.getZCJ();
            double zcjd = fivetohun(zcj);
            xfxcj += zcjd * xf;
        }
        return xfxcj / xftotal;
    }

    public double getAveCredits(String studentid) {
        ArrayList<ScoreJsonInfo.ScoreInfo> scoreList = getScore.getScoreList(getScore.getSorceFromWebservice(studentid));
        Iterator<ScoreJsonInfo.ScoreInfo> list = scoreList.iterator();
        double xftotal = 0;
        double coursetotal = 0;
        while (list.hasNext()) {
            ScoreJsonInfo.ScoreInfo people = list.next();
            double xf = Integer.valueOf(people.getXF());
            xftotal += Integer.valueOf(people.getXF());
            String zcj = people.getZCJ();

            double zcjd = fivetohun(zcj);
            double course = 0;
            if (zcjd >= 60) {
                course = zcjd / 10 - 5;
            }
            coursetotal += course * xf;
        }
        return coursetotal/xftotal;
    }
}
