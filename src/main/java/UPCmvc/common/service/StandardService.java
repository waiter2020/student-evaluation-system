package UPCmvc.common.service;

import UPCmvc.common.model.StandardDoc;
import UPCmvc.common.repository.StandardDevRepository;
import UPCmvc.common.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanghaojun on 2017/4/24.
 */
@Service
public class StandardService {

    @Autowired
    private StandardRepository standardRepository;

    public StandardDoc createStandard(String content) {
        StandardDoc standard=new StandardDoc(content);
        return standardRepository.save(standard);
    }

    public void deleteStandard(int id){
        standardRepository.delete(id);
    }

    public Iterable<StandardDoc> listStandard(){
        return standardRepository.findAll();
    }

    public StandardDoc findOne(int id){
        return standardRepository.findOne(id);
    }

}
