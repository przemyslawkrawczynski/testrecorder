package pl.streamsoft.testrecorder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.streamsoft.testrecorder.entity.TestStep;

@Repository
public interface TestStepRepository extends CrudRepository<TestStep, Long> {
}
