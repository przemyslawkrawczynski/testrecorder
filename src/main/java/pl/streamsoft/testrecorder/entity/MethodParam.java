package pl.streamsoft.testrecorder.entity;

import pl.streamsoft.testrecorder.entity.TestStep;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class MethodParam implements Serializable {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "test_step_id")
    private TestStep testStep;
    @Column
    private String className;
    @Column
    private String value;

    public MethodParam(String className, String value) {
        this.className = className;
        this.value = value;
    }

    public MethodParam(TestStep testStep, String className, String value) {
        this.testStep = testStep;
        this.className = className;
        this.value = value;
    }

    public MethodParam() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestStep getTestStep() {
        return testStep;
    }

    public void setTestStep(TestStep testStep) {
        this.testStep = testStep;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
