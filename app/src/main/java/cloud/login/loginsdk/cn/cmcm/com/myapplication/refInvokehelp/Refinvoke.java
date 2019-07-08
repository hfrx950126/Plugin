package cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Refinvoke {

    public static Object createObject(String className, Class[] pareTyples, Object[] pareVaules) {
        try {
            Class r = Class.forName(className);
            Constructor ctor = r.getDeclaredConstructor(pareTyples);
            ctor.setAccessible(true);
            return ctor.newInstance(pareVaules);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeInstanceMethod(Object obj, String methodName,
                                              Class[] pareTyples, Object[] pareValues) {

        if (obj == null) {
            return null;
        }
        try {
            //在指定类中获得指定方法
            Method method = obj.getClass().getDeclaredMethod(methodName, pareTyples);
            method.setAccessible(true);
            return method.invoke(obj, pareValues);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Object invokeStaticMethod(String className, String method_name, Class[] pareTyples, Object[] pareVaules) {
        try {
            Class obj_class = Class.forName(className);
            Method method = obj_class.getDeclaredMethod(method_name, pareTyples);
            method.setAccessible(true);
            return method.invoke(null, pareVaules);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getStaticFieldObject(String className, String fieldName) {
        return getFieldObject(className, null, fieldName);
    }


    public static Object getFieldObject(Object obj, String fieldName) {


        return getFieldObject(obj.getClass(), obj, fieldName);
    }


    public static Object getFieldObject(Class clazz, Object obj, String fieldName) {


        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Object getFieldObject(String classname, Object obj, String fieldName) {


        Class obj_class = null;


        try {
            obj_class = Class.forName(classname);
            Field field = obj_class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldObject(Class clazz, Object obj, String filedName, Object filedValue) {

        try {
            Field field = clazz.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(obj, filedValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void setFieldObject(Object obj, String filedName, Object filedValue) {
        setFieldObject(obj.getClass(), filedName, filedValue);
    }

    public static void setFieldObject(String className, Object obj, String filedName, Object filedValue) {

        try {
            Class obj_class = Class.forName(className);
            Field field = obj_class.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(obj, filedValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
