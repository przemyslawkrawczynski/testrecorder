package pl.streamsoft.testrecorder.entity;

import pl.streamsoft.testrecorder.entity.TestStep;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class MethodParam {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "test_step_id")
    private TestStep testStep;
    @Column
    private String className;
    @Column
    private String value;

    public MethodParam(Long id, TestStep testStep, String className, String value) {
        this.id = id;
        this.testStep = testStep;
        this.className = className;
        this.value = value;
    }

    public MethodParam(TestStep testStep, String className, String value) {
        this.testStep = testStep;
        this.className = className;
        this.value = value;
    }




}
