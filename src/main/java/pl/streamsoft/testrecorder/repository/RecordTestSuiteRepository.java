package pl.streamsoft.testrecorder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.streamsoft.testrecorder.entity.RecordTestSuite;

@Repository
public interface RecordTestSuiteRepository extends CrudRepository<RecordTestSuite, Long> {
}
