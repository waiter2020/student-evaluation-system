package UPCmvc.common.repository;

import UPCmvc.common.model.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/4/7.
 */
public interface AdminRepository extends CrudRepository<Admin,Integer> {
    public Iterable<Admin> findAllByClassId(int classId);
    public Admin findFirstByStuNum(String id);

}