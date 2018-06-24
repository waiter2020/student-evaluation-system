package UPCmvc.development.service;

import UPCmvc.development.dao.DevReportDao;
import UPCmvc.development.dto.StatusDto;
import UPCmvc.development.model.DevReport;
import org.apache.tomcat.jni.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lylllcc on 2017/4/17.
 */
@Service
public class FileUploadService {
    private String filePath;

    @Autowired
    DevReportDao devReportDao;

    public void fileUp(int id,MultipartHttpServletRequest multiReq) {
        // 获取上传文件的路径
        String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
        System.out.println("uploadFlePath:" + uploadFilePath);
        // 截取上传文件的文件名
        String uploadFileName = uploadFilePath.substring(
                uploadFilePath.lastIndexOf('\\') + 1, uploadFilePath.indexOf('.'));
        System.out.println("文件名:" + uploadFileName);
        // 截取上传文件的后缀
        String uploadFileSuffix = uploadFilePath.substring(
                uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
        System.out.println("uploadFileSuffix:" + uploadFileSuffix);
        DevReport devReport = devReportDao.findOne(id);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //建立文件输入流--从表单上拿到文件
            fis = (FileInputStream) multiReq.getFile("file1").getInputStream();
            //查看工程根目录下有没有“uploadFiles”这个文件夹，没有的话新建
            File file = new File(".//uploadFiles");
            if (!file.exists()){
                file.mkdir();
                System.out.println(file.getCanonicalPath());
            }
            //建立文件输出流，输出目的地：./uploadFiles/文件名.后缀
            String path = ".//uploadFiles//" +uploadFileName+System.currentTimeMillis()
                    + "." + uploadFileSuffix;
            fos = new FileOutputStream(new File( path));//

            filePath = path;
            System.out.println("filePath:"+filePath);
            devReport.setFile(filePath);
            devReportDao.save(devReport);
            System.out.println(fos.toString());
            byte[] temp = new byte[1024];
            int i = fis.read(temp);
            while (i != -1){
                fos.write(temp,0,temp.length);
                fos.flush();
                i = fis.read(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String getFilePath() {
        return filePath;
    }
}
