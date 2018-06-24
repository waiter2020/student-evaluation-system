package UPCmvc.common.controller;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.repository.AdminRepository;
import UPCmvc.common.service.AdminService;
import UPCmvc.common.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaojun on 2017/4/7.
 */
@RestController
@RequestMapping("/common")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    private ClassService classService;

    /***
     * 添加管理员
     * @param identity 身份id
     * @param classId 班级id
     * @param stuNum
     * @param adminName
     * @return
     */
    @RequestMapping(value = "/createadmin", method = RequestMethod.POST)
    public Object createAdmin(int identity, int classId, String stuNum,String adminName) {
        adminService.createAdmin(identity, classId, stuNum,adminName);
        return new JsonMes(1, "设置管理员成功");
    }

    /***
     * 删除管理员
     * @param stuId 管理员学号
     * @return
     */
    @RequestMapping(value = "/deleteadmin", method = RequestMethod.POST)
    public Object deleteAdmin(String stuId) {
        adminService.deleteAdmin(stuId);
        return new JsonMes(1, "删除管理员成功");
    }

    /***
     *
     * @return 管理员列表
     */
    @RequestMapping(value = "/listadmin", method = RequestMethod.GET)
    public Object listAdmin() {
        return adminService.listAdmin();
    }

    /***
     *
     * @param classId 班级id
     * @return 班级管理员列表
     */
    @RequestMapping(value = "/listclassadmin", method = RequestMethod.GET)
    public Object listClassAdmin(int classId) {
        return adminService.listClassAdmin(classId);
    }

    /***
     *
     * @param id 管理员id
     * @return 管理员
     */
    @RequestMapping(value = "/findbyadminid", method = RequestMethod.GET)
    public Object findByAdminId(int id) {
        return adminService.findByAdminId(id);
    }


    @RequestMapping(value = "/findbystuid", method = RequestMethod.GET)
    private Object findByStuNum(String stuNum) {
        return adminService.findByStuNum(stuNum);
    }
}
