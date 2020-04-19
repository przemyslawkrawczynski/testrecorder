package pl.streamsoft.testrecorder.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TestStep {

    @Id
    private Long Id;
    @Column
    private String controllerClassName;
    private String methodName;
    private String methodType;
    @OneToMany(mappedBy = "testStep")
    private List<MethodParam> methodParams;
    @ManyToOne
    @JoinColumn(name = "record_test_suite_id")
    private RecordTestSuite recordTestSuite;
}
