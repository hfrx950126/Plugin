package cloud.login.loginsdk.cn.cmcm.com.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp.Refinvoke;

public class EvilInstrumentation1 extends Instrumentation {
    private static final String TAG = "EvilInstrumentation1";

    Instrumentation mBase;

    public EvilInstrumentation1(Instrumentation base){
       mBase = base;
    }

    @Override
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Log.e(TAG,"到此一游");
        return mBase.newActivity(cl, className, intent);

    }

    @Override
    public void callActivityOnCreate(Activity activity, Bundle bundle){
        Log.e(TAG,"到此一游");

        Class[] p1 = {Activity.class,Bundle.class};
        Object[] v1 = {activity,bundle};
        Refinvoke.invokeInstanceMethod(mBase,"callActivityOnCreate",p1,v1);
    }
}
