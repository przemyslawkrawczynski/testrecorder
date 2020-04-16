package pl.streamsoft.testrecorder.entity;

import pl.streamsoft.testrecorder.recordparameters.enums.ControllerMethodName;
import pl.streamsoft.testrecorder.recordparameters.enums.MethodParam;

import javax.persistence.*;
import java.util.List;

@Entity
public class TestStep {

    @Id
    private Long Id;
    @Column
    private String controller;
    @Enumerated(EnumType.STRING)
    private ControllerMethodName method;
    @OneToMany(mappedBy = "testStep")
    private List<MethodParam> methodParams;
    @ManyToOne
    @JoinColumn(name = "record_test_suite_id")
    private RecordTestSuite recordTestSuite;
}
