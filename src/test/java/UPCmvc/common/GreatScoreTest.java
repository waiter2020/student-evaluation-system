package UPCmvc.common;

import UPCmvc.StudentEvaluationSystemApplication;
import UPCmvc.common.score.GetScoreCredits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * Created by lylllcc on 2017/6/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudentEvaluationSystemApplication.class)
@WebAppConfiguration
public class GreatScoreTest {

    @Autowired
    private GetScoreCredits getScoreCredits;

    @Test
    @Transactional
    @Rollback
    public void testScore(){
//        String proxyHost = "127.0.0.1";
//        String proxyPort = "1080";
//        System.setProperty("http.proxyHost", proxyHost);
//        System.setProperty("http.proxyPort", proxyPort);
////        System.out.println(getScoreCredits.getScoreCredits("1608020120"));
////        System.out.println(getScoreCredits.getAveCredits("1608020120"));
//
//        System.out.println(getScoreCredits.getScoreCredits("1608030228"));
//        System.out.println(getScoreCredits.getAveCredits("1608030228"));
    }


}
