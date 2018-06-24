package UPCmvc.common.controller;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.service.ClassService;
import UPCmvc.common.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wanghaojun on 2017/6/14.
 */
@RestController
@RequestMapping("/common")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    /***
     * 获取管理员名下某专业所有班级
     * @param professionId 专业编号
     * @param adminId 管理员Id
     * @return Iterable
     */
    @RequestMapping(value = "/getclass", method = RequestMethod.GET)
    public Object getAllClass(int professionId,String adminId) {
        System.out.println(adminId);
        return classService.findByProfessionIdAndAdminId(professionId,adminId);
    }

    /***
     * @javadoc 获取管理员名下所有班级
     * @param adminId 管理员Id
     * @return Iterable
     */
    @RequestMapping(value = "/getallclass", method = RequestMethod.GET)
    public Object getAClass(String adminId) {
        return classService.listClass(adminId);
    }

    /***
     *
     * @param classId 班级id
     * @return 班级名称
     */
    //获取班级名字
    @RequestMapping(value = "/findoneclass", method = RequestMethod.GET)
    public Object findOne(int classId) {
        return classService.findOne(classId).getClassName();
    }

    /***
     * 添加学生
     * @param classId 班级id
     * @param stuNumber 学生学号
     * @return
     */
    @PostMapping("/addStu")
    public Object addStu(int classId, int stuNumber) {
        try {
            classService.addStu(classId,stuNumber);
            return new JsonMes(1,"添加成功");
        }catch (Exception e){
            return new JsonMes(-1,"添加失败，请稍后重试");
        }
    }
    /***
     * 删除学生
     * @param classId 班级id
     * @param stuNumber 学生学号
     * @return
     */
    @PostMapping("/deStu")
    public Object de(int classId, int stuNumber) {
        try {
            classService.deStu(classId,stuNumber);
            return new JsonMes(1,"删除成功");
        }catch (Exception e){
            return new JsonMes(-1,"删除失败，请稍后重试");
        }
    }

    /***
     * 通过班级名称获取班级ID
     * @param className
     * @return
     */
    @RequestMapping(value = "/getclassid",method = RequestMethod.POST)
    public int getClassId(String className){
        return classService.getClassId(className);
    }

}
