package UPCmvc.development.controller;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.model.Grade;
import UPCmvc.common.repository.GradeRepository;
import UPCmvc.common.service.WriteExcelService;
import UPCmvc.development.util.CompressUtil;
import UPCmvc.development.util.FileDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.Iterator;

/**
 * Created by lylllcc on 2017/7/21.
 */

@RestController
@RequestMapping("/download")
public class DownLoadController {


    @Autowired
    private WriteExcelService writeExcelService;

    @Autowired
    private GradeRepository gradeRepository;


    @RequestMapping("/data")
    public Object dataDownload(HttpServletResponse response, String studentId) throws IOException {

        String rawPath = "./uploadFiles/" + studentId;
        String targetPath = "./uploadFiles/" + studentId + ".zip";

        File file = new File(rawPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        CompressUtil.compress(rawPath, targetPath);
        FileDownload fileDownload = new FileDownload();
        fileDownload.fileDownload(response, studentId + ".zip", targetPath);
        File zip = new File(targetPath);
        zip.delete();
        return new JsonMes(1, "下载");
    }

    @RequestMapping("/excel")
    public Object excelDownload(HttpServletResponse response, int classId) throws IOException {
        String targetPath = "./uploadFiles/excel/class" + classId + ".xls";
        File excel = new File(targetPath);
        Iterator<Grade> gradeIterator = gradeRepository.findByClassIdOrderByStuNum(classId).iterator();
        writeExcelService.writeExcel(gradeIterator, classId);
        FileDownload fileDownload = new FileDownload();
        fileDownload.fileDownload(response, "class" + classId + ".xls", targetPath);
        excel.delete();
        return new JsonMes(1, "excel");
    }
}
