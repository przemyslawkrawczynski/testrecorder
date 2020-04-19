package pl.streamsoft.testrecorder.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class TestStep implements Serializable {

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

    public TestStep(Long id, String controllerClassName, String methodName, String methodType, List<MethodParam> methodParams, RecordTestSuite recordTestSuite) {
        Id = id;
        this.controllerClassName = controllerClassName;
        this.methodName = methodName;
        this.methodType = methodType;
        this.methodParams = methodParams;
        this.recordTestSuite = recordTestSuite;
    }

    public TestStep() {
    }

    public TestStep(String controllerClassName, String methodName, String methodType, List<MethodParam> methodParams, RecordTestSuite recordTestSuite) {
        this.controllerClassName = controllerClassName;
        this.methodName = methodName;
        this.methodType = methodType;
        this.methodParams = methodParams;
        this.recordTestSuite = recordTestSuite;
    }

    public TestStep(String controllerClassName, String methodName, String methodType, List<MethodParam> methodParams) {
        this.controllerClassName = controllerClassName;
        this.methodName = methodName;
        this.methodType = methodType;
        this.methodParams = methodParams;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getControllerClassName() {
        return controllerClassName;
    }

    public void setControllerClassName(String controllerClassName) {
        this.controllerClassName = controllerClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public List<MethodParam> getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(List<MethodParam> methodParams) {
        this.methodParams = methodParams;
    }

    public RecordTestSuite getRecordTestSuite() {
        return recordTestSuite;
    }

    public void setRecordTestSuite(RecordTestSuite recordTestSuite) {
        this.recordTestSuite = recordTestSuite;
    }

    public void addParam(MethodParam methodParam) {
        methodParams.add(methodParam);
    }

    @Override
    public String toString() {

        String params = "";

        for (MethodParam param: methodParams) {
            params = param.getClassName() + " | " + param.getValue() + "\n";
        }


        return "TestStep{" +
                "Id=" + Id +
                ", controllerClassName='" + controllerClassName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodType='" + methodType + '\'' +
                ", params:\n" + params +
                '}';
    }
}
