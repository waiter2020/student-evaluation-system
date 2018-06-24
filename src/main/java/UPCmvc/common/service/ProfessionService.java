package UPCmvc.common.service;

import UPCmvc.common.model.Profession;
import UPCmvc.common.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanghaojun on 2017/4/24.
 */
@Service
public class ProfessionService {

    @Autowired
    private ProfessionRepository professionRepository;

    public Profession createProfession(String professionName, String college){
        Profession profession = new Profession(professionName,college);
        return professionRepository.save(profession);
    }

    public Iterable<Profession> listProfession(){
        return professionRepository.findAll();
    }

    public void deleteProfession(int professionId){
        professionRepository.delete(professionId);
    }

    public Profession findOne(int id){
        return professionRepository.findOne(id);
    }
}
