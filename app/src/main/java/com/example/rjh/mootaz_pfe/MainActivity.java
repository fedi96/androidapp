package com.example.rjh.mootaz_pfe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // do something
                Intent intent = new Intent(MainActivity.this, Principale.class);
                // If you just use this that is not a valid context. Use ActivityName.this
                startActivity(intent);
                MainActivity.this.finish();
            }
        }, 5000);

    }




}
