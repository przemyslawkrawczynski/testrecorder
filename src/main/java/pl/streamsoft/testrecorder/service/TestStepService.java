package pl.streamsoft.testrecorder.service;

import org.springframework.stereotype.Service;
import pl.streamsoft.testrecorder.entity.TestStep;
import pl.streamsoft.testrecorder.repository.TestStepRepository;

@Service
public class TestStepService {

    private final TestStepRepository repository;

    public TestStepService(TestStepRepository repository) {
        this.repository = repository;
    }

    public Long insert(TestStep testStep) {
       return repository.save(testStep).getId();
    }
}
