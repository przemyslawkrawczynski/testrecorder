package pl.streamsoft.testrecorder.service;

import org.aspectj.lang.JoinPoint;
import pl.streamsoft.testrecorder.entity.TestStep;

import java.io.IOException;

public interface AspectTestStepConverterService {

    TestStep convert(JoinPoint jp) throws IOException, NoSuchMethodException, ClassNotFoundException;
}
