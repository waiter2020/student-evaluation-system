package UPCmvc.common;

import UPCmvc.StudentEvaluationSystemApplication;
import UPCmvc.common.model.Grade;
import UPCmvc.common.repository.GradeRepository;
import UPCmvc.common.service.WriteExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by lylllcc on 2017/7/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudentEvaluationSystemApplication.class)
@WebAppConfiguration
public class ExcelTest {

    @Autowired
    private  GradeRepository gradeRepository;

    @Autowired
    private WriteExcelService writeExcelService;

    @Test
    public void excel() throws IOException {
        //Iterator<Grade> gradeIterator = gradeRepository.findByClassId(1).iterator();
       // writeExcelService.writeExcel(gradeIterator,1);
    }
}
