package UPCmvc.development.controller;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.development.dao.DevReportDao;
import UPCmvc.development.dao.DevScoreDao;
import UPCmvc.development.dto.NumJson;
import UPCmvc.development.dto.StatusDto;
import UPCmvc.development.model.DevReport;
import UPCmvc.development.model.DevScore;
import UPCmvc.development.service.DevelopScoreService;
import UPCmvc.development.service.FileUploadService;
import UPCmvc.development.service.TransCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Created by chenzifeng on 2017/4/30.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/development")
public class ApplyController {

    @Autowired
    DevReportDao devReportDao;
    @Autowired
    DevScoreDao devScoreDao;
    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    TransCodeService transCodeService;
    @Autowired
    DevelopScoreService developScoreService;

    /**
     * @Description:提供
     * @param drId
     * @param studentName
     * @param studentNo
     * @param content
     * @param num
     * @param reader
     * @param suffix
     * */

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public StatusDto createApplication(int drId, String studentName, int studentNo, String content, double num, String reader, String suffix, int classId) throws IOException {

        if (num < 0) {
            return new StatusDto(1, "数据异常");
        }
        DevReport devReport = new DevReport(drId, studentName, studentNo, content, num);
        devReport.setClassId(classId);
        DevReport getReport = devReportDao.save(devReport);
        File file = new File(".//uploadFiles/" + studentNo);
        if (!file.exists()){
            file.mkdirs();
            System.out.println(file.getCanonicalPath());
        }
        System.out.println(reader);
        String path = ".//uploadFiles/"+ studentNo + "/" + System.currentTimeMillis()+"."+suffix;
//        String path = ".//uploadFiles/" + System.currentTimeMillis()+"."+suffix;
        getReport.setFile(path);
        transCodeService.generateImage(reader,path);
        devReportDao.save(getReport);
        return new StatusDto(0, "申请成功");
    }

    @RequestMapping("/getNum")
    public Object getDevNum(int studentId) {
        DevScore devScore = new DevScore(developScoreService.getDScore(studentId), studentId);
        devScoreDao.save(devScore);
        return new NumJson(studentId, developScoreService.getDScore(studentId));
    }

    @RequestMapping("/getAll")
    public Object getAll() {
        return devReportDao.findAll();
    }

    @RequestMapping("/findbyclass")
    public Object getByClass(int classId){return devReportDao.findByClassId(classId);}

    @RequestMapping("/studentGet")
    public Object studentGet(int studentId) {
        return devReportDao.findByStudentNo(studentId);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object deleteApply(int devId){
        DevReport  devReport = devReportDao.findOne(devId);
        if (devReport==null){
            return new JsonMes(-1,"没有该记录");
        }
        devReportDao.delete(devReport);
        return new JsonMes(1,"删除成功");
    }
}
