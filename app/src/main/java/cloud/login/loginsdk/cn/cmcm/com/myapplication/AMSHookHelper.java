package cloud.login.loginsdk.cn.cmcm.com.myapplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp.Refinvoke;

public class AMSHookHelper {
    public static final String EXTRA_TARGET_INTENT = "extra_target_intent";

    public static void hookAMN() throws ClassNotFoundException,
            NoSuchMethodException,InvocationTargetException,IllegalAccessException,NoSuchFieldError{

        //获取AMN的gDefault单例的gDefault,gDefault是final静态的
        Object gDefault = Refinvoke.getStaticFieldObject("android.app.ActivityManagerNative","gDefault");

        //gDefault 是一个android.util.Singleton<T>对象；取出这个单例中的mInstance字段。
        Object mInstance = Refinvoke.getFieldObject("android.util.Singleton",gDefault,
                "mInstance");

        Class<?> classB2Interface = Class.forName("android.app.IActivityManager");
        Object proxy = Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[] {classB2Interface},
                new MockClass1(mInstance));

        //gDefault的mInstance字段，修改为proxy
        Refinvoke.setFieldObject("android.util.Singleton",gDefault,"mInstance",proxy);

    }
}
