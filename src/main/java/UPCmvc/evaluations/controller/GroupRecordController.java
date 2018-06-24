package UPCmvc.evaluations.controller;

import UPCmvc.evaluations.model.GroupRecord;
import UPCmvc.evaluations.service.GroupRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by waiter on 18-4-17.
 */
@RestController
@RequestMapping("/evaluations")
public class GroupRecordController {
    @Autowired
    GroupRecordService groupRecordService;

    /***
     * 获取小组测评列表
     * @param stuNum 组员学号
     * @param classId 班级id
     * @return 列表
     */
    @RequestMapping(value = "/getgrouprecord",method = RequestMethod.POST)
    public Object getRecord(String stuNum,String classId){
        return groupRecordService.getGropRecord(stuNum,classId);
    }

    /***
     * 保存列表
     * @param groupRecords 链表
     * @param b 是否提交 true=提交 false=暂存
     * @return 结果
     */
    @RequestMapping(value = "/savegroup",method = RequestMethod.POST)
    public Object save(@RequestBody List<GroupRecord> groupRecords,boolean b){
        return groupRecordService.save(groupRecords,b);
    }
}
