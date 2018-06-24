package UPCmvc.common.repository;

import UPCmvc.common.model.Class;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/4/6.
 */

public interface ClassRepository extends CrudRepository<Class,Integer> {

    public Iterable<Class> findByProfessionId(int professionId);
    public Iterable<Class> findByProfessionIdAndAdminId(int professionId,String adminId);

    public Iterable<Class> findByAdminId(String adminId);
    public Class findClassById(int classId);
    public Class findClassByClassNameLike(String className);
    Class findFirstByStudenNumber(int stuid);
}
