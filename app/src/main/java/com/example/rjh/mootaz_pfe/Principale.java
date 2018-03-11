package com.example.rjh.mootaz_pfe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class Principale extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principale);
    }
    public void adminLogin(View arg0){
        Intent intent = new Intent(Principale.this, login.class);
        startActivity(intent);
        Principale.this.finish();
}
    public void actLogin(View arg0){
        Intent intent = new Intent(Principale.this, login_act.class);
        startActivity(intent);
        Principale.this.finish();
    }
    public void userLogin(View arg0){
        Intent intent = new Intent(Principale.this, login_user.class);
        startActivity(intent);
        Principale.this.finish();
    }
    public void exit(View arg0){
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
        finish();
        System.exit(0);
    }
}
