package pl.streamsoft.testrecorder.service.impl;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;
import pl.streamsoft.testrecorder.entity.MethodParam;
import pl.streamsoft.testrecorder.entity.TestStep;
import pl.streamsoft.testrecorder.service.AspectTestStepConverterService;
import pl.streamsoft.testrecorder.service.ConverterJavaObjectService;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class AspectTestStepConverterServiceImpl implements AspectTestStepConverterService {

    private final ConverterJavaObjectService converterService;

    public AspectTestStepConverterServiceImpl(ConverterJavaObjectService converterService) {
        this.converterService = converterService;
    }


    @Override
    public TestStep convert(JoinPoint jp) throws IOException, NoSuchMethodException, ClassNotFoundException {
        String invokedClassName = getInvokedClassName(jp);
        String invokedMethodName = getInvokedMethodName(jp);
        String invokedMethodType = getInvokedMethodType(jp);
        List<MethodParam> params = getParamsList(jp);
        TestStep testStep = new TestStep(invokedClassName, invokedMethodName, invokedMethodType, params);
        System.out.println(testStep.toString());

        return null;
    }

    private List<MethodParam> getParamsList(JoinPoint jp) throws IOException {

        Object[] params = jp.getArgs();
        List<MethodParam> paramsList = new ArrayList<>();

        for (Object object: params) {
            String argsClassName = object.getClass().getName();
            String value = converterService.convertToStringSerializableObject(object);
            paramsList.add(new MethodParam(argsClassName, value));
        }

        System.out.println("Args num: " + paramsList.size());
        System.out.println("Args class: " + paramsList.get(0).getClassName());
        System.out.println("Args value: " + paramsList.get(0).getValue());
         return paramsList;
    }

    public String getInvokedClassName(JoinPoint jp) {
        return jp.getSignature().getDeclaringTypeName();
    }

    public String getInvokedMethodName(JoinPoint jp) {
        return jp.getSignature().getName();
    }

    private String getInvokedMethodType(JoinPoint jp) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> controllerClass = Class.forName(jp.getSignature().getDeclaringTypeName());
        Method calledMethod = controllerClass.getDeclaredMethod(getInvokedMethodName(jp), getParamsClass(jp.getArgs()));
        return calledMethod.getGenericReturnType().getTypeName();

    }

    private Class[] getParamsClass(Object[] params) {
        Class[] classes = new Class[params.length];

        for (int i=0; i < params.length; i++) classes[i] = params[i].getClass();

        return classes;
    }


}
