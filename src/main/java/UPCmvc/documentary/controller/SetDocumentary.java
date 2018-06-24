package UPCmvc.documentary.controller;

import UPCmvc.common.dto.JsonMes;

import UPCmvc.documentary.dao.DocumentaryDao;
import UPCmvc.documentary.model.Documentary;
import UPCmvc.documentary.service.ComputerService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zfl on 2017/4/30.
 */
@RestController
@RequestMapping("/documentary")
public class SetDocumentary {

    @Autowired
    private DocumentaryDao documentaryDao;

    @Autowired
    private ComputerService computerService;

    //班长提交信息
    @RequestMapping("/setDocumentary")
    @JsonIgnore
    public Object setter(int studentNumber, int projectNumber, int score,String text){
        Documentary documentary = new Documentary(studentNumber, projectNumber, score,text);
        documentary.setAgree(true);
        try{
            documentaryDao.save(documentary);
            computerService.computerGrade(studentNumber);
            return new JsonMes(1, "创建成功");
        }catch (Exception err){
            String error = err.toString();
            return new JsonMes(0, error);
        }
    }
    //找所有记录
    @RequestMapping("/getDocument")
    public Object getter(){
        return documentaryDao.findAll();
    }
    //学生找自己的纪实记录
    @RequestMapping("/getDocumentByNumber")
    public Object getByNumber(int studentNumber){
        return documentaryDao.findByStudentNumber(studentNumber);
    }

    //老师是否同意
    @RequestMapping("/setDocumentaryByteacher")
    public Object setDocumentaryByteacher(int id,int studentNumber, int score, boolean isAgree){
       //Documentary documentary = new Documentary(id, studentNumber, projectNumber, score, isAgree);
        try{
            Documentary documentary = documentaryDao.findOne(id);
            documentary.setAgree(isAgree);
            documentaryDao.save(documentary);
            computerService.computerGrade(studentNumber);
            return new JsonMes(1, "确认成功");
        }catch (Exception err){
            String error = err.toString();
            return new JsonMes(0, error);
        }
    }
    @RequestMapping("/delete")
    public Object deleteDocumentaryByteacher(int id){
        //Documentary documentary = new Documentary(id, studentNumber, projectNumber, score, isAgree);
        try{
            Documentary documentary = documentaryDao.findOne(id);
            documentaryDao.delete(documentary);
            return new JsonMes(1, "确认成功");
        }catch (Exception err){
            String error = err.toString();
            return new JsonMes(0, error);
        }
    }
}
