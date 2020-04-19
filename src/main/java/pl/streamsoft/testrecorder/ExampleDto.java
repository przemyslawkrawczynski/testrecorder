package pl.streamsoft.testrecorder;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExampleDto implements Serializable {
    public Long id;
    public String name;
    public BigDecimal value;

    public ExampleDto(Long id, String name, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}