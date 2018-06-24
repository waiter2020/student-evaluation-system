package UPCmvc.evaluation.controller;

import UPCmvc.evaluation.model.EvaluationRecord;
import UPCmvc.evaluation.service.EvaRecordService;
import UPCmvc.evaluation.service.GroupEvaGradeService;
import UPCmvc.evaluation.service.StudentEvaGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaojun on 2017/5/1.
 */
@RestController
@RequestMapping("/evaluation")
public class EvaController {

    @Autowired
    private EvaRecordService evaRecordService;

    @Autowired
    private GroupEvaGradeService groupEvaGradeService;

    @Autowired
    private StudentEvaGradeService studentEvaGradeServicess;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Object createEvaRecord(String evaluatorNum, int beEvaluatedNum, char grade,int identity){
        return evaRecordService.createEvaRecord(evaluatorNum,beEvaluatedNum,grade,identity);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateEvaRecord(String evaluatorNum, int beEvaluatedNum, char grade,int identity)
    {
        return evaRecordService.updateEvaRecord(evaluatorNum,beEvaluatedNum,grade,identity);
    }

    @RequestMapping("/findbybeevaluated")
    public Object findByBeEvaluatedNum(int stuId){
        return evaRecordService.findByBeEvaluatedNum(stuId);
    }

    @RequestMapping("/findbyevaluator")
    public Object findByEvaluatorNum(String stuId){
        return evaRecordService.findByEvaluatorNum(stuId);
    }

    @RequestMapping("/findonegroupgrade")
    public Object findOneGroupGrade(int stuId){
        return groupEvaGradeService.findByStuId(stuId);
    }

    @RequestMapping("/findonestugreade")
    public Object findOneStuGrade(int stuId){
        return studentEvaGradeServicess.findGrade(stuId);
    }

    @RequestMapping("/getnotevaluate")
    public Object getNotEvaluate(String stuId,int classId){
        return evaRecordService.getNotEvaluated(stuId,classId);
    }






}
