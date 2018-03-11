package com.example.rjh.mootaz_pfe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class userhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
    }
    public void retour(View arg0){
        setContentView(R.layout.activity_userhome);
    }
    public void ajques(View arg0){
        Intent intent = new Intent(com.example.rjh.mootaz_pfe.userhome.this,new_q.class);
        startActivity(intent);
        userhome.this.finish();
    }
    public void question(View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("Liste Question");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/question.inc.php");
    }
    public void refresh(View arg0){
        WebView myWebView=findViewById(R.id.wbvw);
        myWebView.reload();
    }
    public void exit(View arg0){
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
        finish();
        System.exit(0);
    }
}
