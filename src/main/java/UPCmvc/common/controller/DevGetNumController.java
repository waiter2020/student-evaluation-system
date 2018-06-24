package UPCmvc.common.controller;

import UPCmvc.common.repository.StandardDevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenzifeng on 2017/6/28.
 */
@RestController
@RequestMapping("/common")
public class DevGetNumController {
    @Autowired
    private StandardDevRepository devRepository;


    @RequestMapping("/getDevNum")
    public Object getDevNum(){
        return devRepository.findAll();
    }
}
