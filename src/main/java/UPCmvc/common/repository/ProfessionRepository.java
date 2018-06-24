package UPCmvc.common.repository;

import UPCmvc.common.model.Profession;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/4/6.
 */
public interface ProfessionRepository extends CrudRepository<Profession,Integer> {

    Profession findFirstByProfessionName(String name);
}
