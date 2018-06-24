package UPCmvc.common.controller;

import UPCmvc.common.model.Profession;
import UPCmvc.common.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaojun on 2017/6/14.
 */

@RestController
@RequestMapping("/common")
public class ProfessionController {

    @Autowired
    ProfessionService professionService;

    @RequestMapping(value = "/listprofession",method = RequestMethod.GET)
    public Object listProfession(){
        return professionService.listProfession();
    }
    //获取专业名字
    @RequestMapping(value = "/findoneprofession",method = RequestMethod.GET)
    public String findOne(int id){
        Profession profession=professionService.findOne(id);
        return profession.getProfessionName();
    }


}
