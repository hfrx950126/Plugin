package cloud.login.loginsdk.cn.cmcm.com.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp.Refinvoke;

public class EvilInstrumentation extends Instrumentation {

    private static final String TAG = "EvilInstrumentation";

    Instrumentation mBase;

    public EvilInstrumentation(Instrumentation base) {
        mBase = base;
    }
    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent,int requestCode,Bundle options){
        Log.e(TAG,"xxxxxxx到此一游");
     Class[] p1 = {Context.class,IBinder.class,IBinder.class,Activity.class,
             Intent.class,int.class,Bundle.class};
     Object[] v1 = {who,contextThread,token,target,intent,requestCode,options};

     return (ActivityResult) Refinvoke.invokeInstanceMethod(mBase,"execStartActivity",p1,v1);
    }
}
