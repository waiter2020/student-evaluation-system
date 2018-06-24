package UPCmvc.common;

import UPCmvc.common.service.ClassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassTest {

    @Autowired
    private ClassService classService;

    @Test
    public void isAdmin(){
        System.out.println(classService.isClassAdmin(14,"Q20160041"));
    }
}
