package UPCmvc.evaluations.controller;

import UPCmvc.evaluation.service.StudentEvaGradeService;
import UPCmvc.evaluations.model.StudentRecord;
import UPCmvc.evaluations.service.StudentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by waiter on 18-4-16.
 */

@RestController
@RequestMapping("/evaluations")
public class StudentRecordController {
    @Autowired
    StudentRecordService studentRecordService;

    /***
     * 获取评价列表
     * @param stuId 学生学号
     * @return 列表
     */
    @RequestMapping(value="/getrecord",method = RequestMethod.POST)
    public Object getRecord(String stuId){
        return studentRecordService.getRecord(stuId);
    }

    /***
     * 保存或提交评价
     * @param studentRecords 评价列表
     * @param b 保存或提交
     * @return 结果消息
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(@RequestBody List<StudentRecord> studentRecords,boolean b){
        return studentRecordService.save(studentRecords,b);
    }
}
