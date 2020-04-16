package pl.streamsoft.testrecorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity
public class RecordTestSuite {

    @Id
    private Long id;
    @Column
    private String operator;
    @Column
    private Date recordDate;
    @OneToMany(
            targetEntity = TestStep.class,
            mappedBy = "recordTestSuite")
    private List<TestStep> testSteps;


}
