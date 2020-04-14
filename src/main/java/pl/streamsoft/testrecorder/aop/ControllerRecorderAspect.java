package pl.streamsoft.testrecorder.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerRecorderAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerRecorderAspect.class);

    private final String SERVICE_POINTCUT = "execution(* pl.streamsoft.testrecorder.controller.*.*(..))";

    @Before(SERVICE_POINTCUT)
    public void logAdvice(JoinPoint jp) throws Throwable {
        LOG.info("[METHOD] : " + jp.getSignature().toShortString());
        Object[] signatureArgs = jp.getArgs();
        for (Object arg: signatureArgs) {
            LOG.info("[ARG] : " + arg);
        }
    }

}
