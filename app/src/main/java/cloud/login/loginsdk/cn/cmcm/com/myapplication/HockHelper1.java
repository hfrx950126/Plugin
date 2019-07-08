package cloud.login.loginsdk.cn.cmcm.com.myapplication;

import android.app.Instrumentation;

import cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp.Refinvoke;

public class HockHelper1 {
    public static void attachContext() throws Exception{
        // 先获取到当前的ActivityThread 对象
        Object currentActivityThread = Refinvoke.invokeStaticMethod("android.app.ActivityThread",
                "currentActivityThread",null,null);

        //拿到原始的mInstrumentation字段
        Instrumentation mInstrumentation = (Instrumentation) Refinvoke.getFieldObject(currentActivityThread,"mInstrumentation");

        //创建代理对象
        Instrumentation evilInstrumentation = new EvilInstrumentation(mInstrumentation);

        //偷梁换柱
        Refinvoke.setFieldObject(currentActivityThread,"mInstrumentation",evilInstrumentation);


    }
}
