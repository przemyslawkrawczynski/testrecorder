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

    public ExampleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}