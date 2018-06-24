package UPCmvc.development.controller;

import UPCmvc.common.model.Admin;
import UPCmvc.common.service.AdminService;
import UPCmvc.common.service.GradeService;
import UPCmvc.development.dao.DevReportDao;
import UPCmvc.development.dto.StatusDto;
import UPCmvc.development.model.DevReport;
import UPCmvc.development.service.DevelopScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * Created by chenzifeng on 2017/6/12.
 */
@RestController
@RequestMapping(value = "/develop_Approve")
public class ApproveContraller {

    @Autowired
    DevReportDao devReportDao;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DevelopScoreService developScoreService;
    @Autowired
    private GradeService gradeService;

    /**
    * 检查申请信息
     * @param studentId
     * @param drId
     * @return
     * studentId 学生学号
     * drId 对应的申请的项目
     * checkId 对应的身份编号
    * */
    @RequestMapping(method = RequestMethod.POST,value = "/check")
    public Object approve(String studentId,int drId) {
//        if (checkId!=0)
//            return new StatusDto(2,"没有权限");
        Admin admin = adminService.findByStuNum(studentId);
        if ("0".equals(admin.getStuNum()))
            return new StatusDto(2, "没有权限");
        if (devReportDao.findByDrIdAndStudentNoOrderByCreateAt(drId, studentId) == null)

            return new StatusDto(-1, "无有效信息");
        return devReportDao.findByDrIdAndStudentNoOrderByCreateAt(drId, studentId);
    }
        /**
         * @param devId
         * @param approve
         * @return
         * devId-对应devReport表中Id,不是drId
         * 申请批准接口
         * approve:
         * 0-未审核
         * 1-成功
         * -1-失败
         */

    @RequestMapping(method = RequestMethod.POST,value = "/approve")
    public Object revoke(int devId,int approve){
        System.out.println(devId);
        DevReport devReport = devReportDao.findOne(devId);

        devReport.setApprove(approve);
        devReportDao.save(devReport);
        gradeService.findOneGrade(devReport.getStudentNo()); //更新成绩
        return new StatusDto(0,"成功");
    }

    @RequestMapping(method = RequestMethod.POST,value = "/feedback")
    public Object setFeedback(int id,String feedback){
        return developScoreService.setFeedback(id,feedback);
    }


}
