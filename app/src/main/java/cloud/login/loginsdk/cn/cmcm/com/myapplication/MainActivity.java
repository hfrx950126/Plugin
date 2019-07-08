package cloud.login.loginsdk.cn.cmcm.com.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;

import cloud.login.loginsdk.cn.cmcm.com.myapplication.refInvokehelp.Refinvoke;

/**
 * @author huangfuruixin
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        try {
            AMSHookHelper.hookAMN();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Instrumentation mInstrumentation = (Instrumentation) Refinvoke.getFieldObject(Activity.class,this,"mInstrumentation");
//        Instrumentation evilInstrumentation = new EvilInstrumentation(mInstrumentation);
//        Refinvoke.setFieldObject(Activity.class,this,"mInstrumentation",evilInstrumentation);


        Button tv = new Button(this);
        tv.setText("测试界面");
        setContentView(tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
