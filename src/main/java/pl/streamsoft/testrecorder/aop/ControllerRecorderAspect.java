package pl.streamsoft.testrecorder.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.streamsoft.testrecorder.service.AspectTestStepConverterService;
import pl.streamsoft.testrecorder.service.TestStepService;

@Component
@Aspect
public class ControllerRecorderAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerRecorderAspect.class);
    private final String SERVICE_POINTCUT = "execution(* pl.streamsoft.testrecorder.controller.*.*(..))";

    private final AspectTestStepConverterService converterService;
    private final TestStepService testStepService;

    public ControllerRecorderAspect(AspectTestStepConverterService converterService, TestStepService testStepService) {
        this.converterService = converterService;
        this.testStepService = testStepService;
    }

    @Before(SERVICE_POINTCUT)
    public void saveControllerStep(JoinPoint jp) throws Throwable {
        //testStepService.insert(converterService.convert(jp));
        converterService.convert(jp);
    }

}
