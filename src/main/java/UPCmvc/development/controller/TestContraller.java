package UPCmvc.development.controller;

import UPCmvc.development.dao.DevReportDao;
import UPCmvc.development.dto.StatusDto;
import UPCmvc.development.service.TransCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenzifeng on 2017/6/14.
 */
@RestController
@RequestMapping("/DRtest")
public class TestContraller {

    @Autowired
    private DevReportDao devReportDao;

//    @Autowired
//    private HttpSession httpSession;
    @Autowired
    private TransCodeService transCodeService;





    @RequestMapping(value = "/file1",method = RequestMethod.POST)
    public Object fileUp(HttpServletRequest httpServletRequest,MultipartFile multipartFiles) throws IOException{

        //得到上传的文件名
        String fileName = multipartFiles.getOriginalFilename();
        System.out.println("filename:"+fileName);
        //得到服务器项目发布运行所在地址
        String path1 = httpServletRequest.getSession().getServletContext().getRealPath("image")+File.separator;
        //  此处未使用UUID来生成唯一标识,用日期做为标识
        String path = path1+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ fileName;
        String filePath = path;
        //查看文件上传路径,方便查找
        System.out.println(path);
        //把文件上传至path的路径
        File localFile = new File(path);
        multipartFiles.transferTo(localFile);

        return new StatusDto(0,"上传成功");
    }

    @RequestMapping(value = "/transcode",method = RequestMethod.POST)
    public void transcode(String img) throws IOException {
        if (img == null)
            System.out.println("信息为空");

    }
}
