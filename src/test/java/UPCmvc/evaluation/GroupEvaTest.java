package UPCmvc.evaluation;

import UPCmvc.StudentEvaluationSystemApplication;
import UPCmvc.common.repository.StudentRository;
import UPCmvc.common.service.StudentService;
import UPCmvc.evaluation.service.GroupEvaGradeService;
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
public class GroupEvaTest {
    @Autowired
    StudentRository studentRository;
    @Autowired
    StudentService studentService;
    @Autowired
    GroupEvaGradeService groupEvaGradeService;

    @Test
    @Transactional
    @Rollback
    public void comGradeTest(){
        groupEvaGradeService.computerGroupEvaGrade(1507020329);
    }

}
