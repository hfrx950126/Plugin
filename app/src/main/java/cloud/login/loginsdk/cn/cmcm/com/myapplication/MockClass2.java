package cloud.login.loginsdk.cn.cmcm.com.myapplication;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp.Refinvoke;

class MockClass2 implements Handler.Callback {
    Handler mBase;

    public MockClass2(Handler base) {
        mBase = base;
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 100:
                handleLaunchActivity(msg);
            default:
                break;
        }
        mBase.handleMessage(msg);
        return true;
    }

    private void handleLaunchActivity(Message msg) {
        //这里简单起见，直接取出TargetActivity；
        Object obj = msg.obj;
        Log.e("baobao",obj.toString());

        //把替身恢复成真身
        Intent intent = (Intent) Refinvoke.getFieldObject(obj,"intent");

        Intent targetIntent = intent.getParcelableExtra(AMSHookHelper.EXTRA_TARGET_INTENT);

        intent.setComponent(targetIntent.getComponent());

    }
}
