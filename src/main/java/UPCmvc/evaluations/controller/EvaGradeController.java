package UPCmvc.evaluations.controller;

import UPCmvc.evaluations.service.EvaGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dalao on 18-4-23.
 */
@RestController
public class EvaGradeController {
    @Autowired
    private EvaGradeService evaGradeService;

    /***
     * 获取学生评价信息
     * @param stuNum 学号
     * @return
     */
    @RequestMapping(value = "geteva",method = RequestMethod.POST)
    public Object getEva(String stuNum){
        return evaGradeService.getEva(stuNum);
    }
}
