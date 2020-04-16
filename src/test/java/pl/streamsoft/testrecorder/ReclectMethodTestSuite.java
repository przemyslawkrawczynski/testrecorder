package pl.streamsoft.testrecorder;

import org.junit.jupiter.api.Test;
import pl.streamsoft.testrecorder.controller.PubController;
import pl.streamsoft.testrecorder.controller.TestController;
import pl.streamsoft.testrecorder.reflect.ReflectMethodInvocationService;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

public class ReclectMethodTestSuite {

    @Test
    public void should_invoke_private_method() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        //Given
        PubController controller = new TestController();

        //When
        String redsult = (String) ReflectMethodInvocationService.invokeMethod(controller, "show", "one", "two", "three");

        //Then
        assertThat(redsult).isEqualTo("one two three");

    }
}
