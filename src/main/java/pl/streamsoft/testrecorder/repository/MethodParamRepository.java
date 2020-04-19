package pl.streamsoft.testrecorder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.streamsoft.testrecorder.entity.MethodParam;

@Repository
public interface MethodParamRepository extends CrudRepository<MethodParam, Long> {
}
