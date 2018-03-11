package com.example.rjh.mootaz_pfe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public  void exit(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
        finish();
        System.exit(0);
    }
    public void list (View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("Liste Users");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/list.inc.php");
    }
    public void supp (View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);

        Button btn=findViewById(R.id.button);
        btn.setText("Liste Users");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/supp.inc.php");
    }
    public void refresh(View arg0){
        WebView myWebView=findViewById(R.id.wbvw);
        myWebView.reload();
    }

    public void add(View arg0){
        Intent intent = new Intent(Home.this,addnew.class);
        startActivity(intent);
        Home.this.finish();
    }

    public void retour(View arg0){
        setContentView(R.layout.activity_home);
    }

}
