package com.itobia.run1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager pm = getPackageManager() ;
        if(!pm.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.e("MainActivity" , " u dont have FEATURE_FINGERPRINT") ;
        }else {
            Log.i("MainActivity" , " u  have FEATURE_FINGERPRINT") ;
        }
        Log.i("MainActivity" , " your version : " + Build.VERSION.SDK_INT) ;


        ((Button)findViewById(R.id.button) ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //   checkIntentPermission () ;
                Intent intent = new Intent(MainActivity.this , HomeActivity.class ) ;
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG , "GRANTED ") ;
                } else {
                    Log.i(TAG , "not GRANTED ") ;
                }
                return;
            }
        }
    }

    void checkIntentPermission () {
        if(Build.VERSION.SDK_INT >=  23 ) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(new String[]{Manifest.permission.CAMERA }, 0);
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("hello" , "hello");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG , savedInstanceState.getString("hello") ) ;
    }
}
