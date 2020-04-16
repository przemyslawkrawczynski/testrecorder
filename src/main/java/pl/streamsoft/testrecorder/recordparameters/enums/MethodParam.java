package pl.streamsoft.testrecorder.recordparameters.enums;

import pl.streamsoft.testrecorder.entity.TestStep;

import javax.persistence.*;

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

}
