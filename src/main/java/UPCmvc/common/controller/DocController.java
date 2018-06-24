package UPCmvc.common.controller;

import UPCmvc.common.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lylllcc on 2017/6/30.
 */
@RestController
public class DocController {

    @Autowired
    private StandardRepository standardRepository;

    @GetMapping("/doc")
    public Object getAlldoc(){
        return standardRepository.findAll();
    }
}
