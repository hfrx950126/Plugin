package cloud.login.loginsdk.cn.cmcm.com.myapplication;


import android.os.Handler;

import cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp.Refinvoke;

public class HookHelper {
    public static final String EXTRA_TARGET_INTENT = "extra_target_intent";
    public static void attachBaseContext() throws Exception{
        //先获取到当前的ActivityThread对象
        Object currentActivityThread = Refinvoke.getStaticFieldObject("android.app.ActivityThread","sCurrentActivityThread");

        //由于ActivityThread一个进程只有一个，我们获取这个对象的mH
        Handler mH = (Handler) Refinvoke.getFieldObject("android.app.ActivityThread",
                currentActivityThread,"mH");

        //把Handler的mCallback字段，替换为new MockClass2(mH)

        Refinvoke.setFieldObject(Handler.class,mH,"mCallback",new MockClass2(mH));
    }
}
