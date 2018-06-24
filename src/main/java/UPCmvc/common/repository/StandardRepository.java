package UPCmvc.common.repository;

import UPCmvc.common.model.StandardDoc;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chenzifeng on 2017/6/28.
 */
public interface StandardRepository extends CrudRepository<StandardDoc,Integer> {
}
