package UPCmvc.evaluation;

import UPCmvc.StudentEvaluationSystemApplication;
import UPCmvc.evaluation.model.EvaluationRecord;
import UPCmvc.evaluation.service.EvaRecordService;
import UPCmvc.evaluation.service.StudentEvaGradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * Created by wanghaojun on 2017/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudentEvaluationSystemApplication.class)
@WebAppConfiguration
public class StuEvaTest {
    @Autowired
    EvaRecordService evaRecordService;
    @Autowired
    StudentEvaGradeService studentEvaGradeService;


    @Test
//    @Transactional
//    @Rollback
    public void createGroupTest(){

    }

    @Test
    public void isreaptTest(){
        //System.out.println(evaRecordService.isRepeat("1607040220",1607040201));
    }

    @Test
    public void calStuGrade(){
//        double grade=studentEvaGradeService.calAvgGrade(1507020329);
//        System.out.println(grade);
    }

}
