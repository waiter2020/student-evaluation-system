package UPCmvc.common;

import UPCmvc.StudentEvaluationSystemApplication;
import UPCmvc.common.model.Admin;
import UPCmvc.common.service.AdminService;
import UPCmvc.common.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wanghaojun on 2017/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudentEvaluationSystemApplication.class)
@WebAppConfiguration
public class AdminCrudTest {

    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;

    @Test
    @Transactional
    @Rollback
    public void testCRUD(){
//        adminService.createAdmin(123,1,"1","大阳哥");
//        Admin admin=(Admin) adminService.findByStuNum("1507020330");
//        Assert.assertEquals(admin.getId(),1);
    }
    @Test
    @Transactional
    @Rollback
    public void createStuTest(){
     //   studentService.createStudent("计算1601","计算机科学与技术",1507020333,2016,"123","男");
    }



}
