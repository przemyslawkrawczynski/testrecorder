package pl.streamsoft.testrecorder.reflect;

import pl.streamsoft.testrecorder.controller.PubController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethodInvocationService {

    private static Method getMethod(PubController controller, final String method, final Class<?>... clazz) throws NoSuchMethodException, SecurityException {
        Class<?> serviceClass = controller.getClass();
        return serviceClass.getDeclaredMethod(method, clazz);
    }

    public static Object invokeMethod(PubController controller, final String method, final Object... objects)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Class<?>[] clazzes = new Class[objects.length];
        for (int i = 0; i < objects.length; i++) {
            clazzes[i] = String.class;
        }

        Method methodToInvoke = getMethod(controller, method, clazzes);
        methodToInvoke.setAccessible(true);

        return methodToInvoke.invoke(controller, objects);
    }


}
