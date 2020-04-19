package pl.streamsoft.testrecorder.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.streamsoft.testrecorder.ExampleDto;
import pl.streamsoft.testrecorder.service.impl.ConverterJavaObjectServiceImpl;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterJavaObjectServiceImplTestSuits {

    @Autowired
    ConverterJavaObjectServiceImpl converterService;

    @Test
    public void should_convert_param_to_object_when_param_is_primitive_class() throws IOException {

        //Given
        long primitiveLong = 1L;
        int primiteInt = 13562;
        float primitiveFloat = 4567f;
        double primitiveDouble = 65428.12;

        //When
        String stringFromObject = converterService.convertToStringSerializableObject(primitiveLong);

        //Then
        assertThat(stringFromObject).isInstanceOf(String.class);
        assertThat(primiteInt).isInstanceOf(Integer.class);
        assertThat(primitiveFloat).isInstanceOf(Float.class);
        assertThat(primitiveDouble).isInstanceOf(Double.class);

    }

    @Test
    public void should_convert_param_to_object_when_param_is_some_Object_class() throws IOException {

        //Given
        ExampleDto exampleDto = new ExampleDto(1L, "ExampleDto", BigDecimal.valueOf(25));

        //When
        String stringFromObject = converterService.convertToStringSerializableObject(exampleDto);

        //Then
        assertThat(stringFromObject).isInstanceOf(String.class);
    }

    @Test
    public void should_convert_param_from_serialized_String_to_object_primitive_classes() throws IOException, ClassNotFoundException {

        //Given
        Long longValue = 12345L;
        String primitiveLongAsString = converterService.convertToStringSerializableObject(longValue);

        //When
        Long result = (Long) converterService.convertFromStringToObject(primitiveLongAsString);

        //Then
        assertThat(result).isEqualTo(longValue);
    }

    @Test
    public void should_convert_param_from_serialized_String_to_object_dtoExample() throws IOException, ClassNotFoundException {

        //Given
        ExampleDto exampleDto = new ExampleDto(1L, "ExampleDto", BigDecimal.valueOf(25));
        String primitiveLongAsString = converterService.convertToStringSerializableObject(exampleDto);

        //When
        ExampleDto result = (ExampleDto) converterService.convertFromStringToObject(primitiveLongAsString);

        //Then
        assertThat(result.id).isEqualTo(exampleDto.id);
        assertThat(result.name).isEqualTo(exampleDto.name);
        assertThat(result.value).isEqualTo(exampleDto.value);
    }

    @Test
    public void should_convert_param_to_object_when_param_is_null() throws IOException {

        //Given
        Object nullableObject = null;

        //When
        String stringFromObject = converterService.convertToStringSerializableObject(nullableObject);

        //Then
        assertThat(stringFromObject).isInstanceOf(String.class);
    }


}
