package Reflection;

import Annotations.Author;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Application implements Runnable{

    public static void printClassNames(Class<?> cls) {
        System.out.println(cls.getName());
        System.out.println(cls.getCanonicalName());
    }

    public static void printAnnotationDetails(Annotation annotation) {
        System.out.println("Annotation: "+annotation);
        System.out.println("Annotation Class Name: "+annotation.getClass());
    }

    public static void printParameterDetails(Parameter parameter) {
        System.out.println("Parameter: "+parameter);
        System.out.println(parameter.getName());
        System.out.println(parameter.getType());
    }

    public static void printMethodDetails(Method method) {
        System.out.println("Method: "+method);

        System.out.println("Annotation Details: ");
        for(Annotation annotation:method.getAnnotations()) {
            printAnnotationDetails(annotation);
        }
        System.out.println("==========================");

        System.out.println("Parameters Details: ");
        for(Parameter parameter:method.getParameters()) {
            printParameterDetails(parameter);
        }
        System.out.println("==========================");
    }

    public static void printMethods(Class<?> cls) {
        System.out.println("Print class methods: ");
        for(Method method:cls.getMethods()) {
            printMethodDetails(method);
        }

        System.out.println("Print declared class methods: ");
        for(Method method:cls.getDeclaredMethods()) {
            printMethodDetails(method);
        }
    }

    public static void printFieldDetails(Field field) {
        System.out.println(field);
        System.out.println(field.getType());
    }

    public static void printFields(Class<?> cls) {
        System.out.println("Print Fields: ");
        for(Field field: cls.getFields()) {
            printFieldDetails(field);
        }

        System.out.println("Print Declared Fields: ");
        for(Field field: cls.getDeclaredFields()) {
            printFieldDetails(field);
        }
    }

    public static void printConstructorDetails(Constructor constructor) {
        System.out.println(constructor);
    }

    public static void printConstructors(Class<?> cls) {
        System.out.println("Print Constructors: ");
        for(Constructor constructor: cls.getConstructors()) {
            printConstructorDetails(constructor);
        }

        System.out.println("Print Declared Constructors: ");
        for(Constructor constructor: cls.getDeclaredConstructors()) {
            printConstructorDetails(constructor);
        }
    }

    @Override
    public void run() {
        Class cls = Integer.class;
        try {
            Class intClass = Class.forName("java.lang.Integer");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        printClassNames(cls);
        printMethods(cls);
        printFields(cls);
        printConstructors(cls);

        try {
            Constructor constructor = cls.getConstructor(String.class);
            Object object = constructor.newInstance("2874");
            System.out.println("Instantiated Object: ");
            System.out.println(object.getClass());
            System.out.println(object);

            Field field = cls.getDeclaredField("value");
            field.setAccessible(true);
            Integer value = (Integer) field.get(object);
            System.out.println("The value of field is: "+value);
            field.set(object, 366);
            value = (Integer) field.get(object);
            System.out.println("The value of field is: "+value);

            Method method = cls.getMethod("toString");
            Object result = method.invoke(object);
            System.out.println(result.getClass());
            System.out.println(result);

            int[] intArray = new int[20];
            float[] floatArray = new float[20];
            Integer[] integerArray = new Integer[10];
            System.out.println(intArray.getClass());
            System.out.println(floatArray.getClass());
            System.out.println(integerArray.getClass());

            Class.forName("[Ljava.lang.Integer;");
            Class intArrayClass = Class.forName("[I");

            System.out.println(intArrayClass.getConstructors().length);
            Array.newInstance(Integer.class, 100);
        }

//        catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
        catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
