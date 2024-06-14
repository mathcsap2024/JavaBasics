package Network.UDP;

import Annotations.Application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SenderMain {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class cls = Application.class;
        Method method=cls.getMethods()[0];
        method.invoke(null);


        SenderApplication application = new SenderApplication();
        application.getClass();
        application.run();
    }
}
