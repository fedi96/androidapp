package com.example.rjh.mootaz_pfe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class acthome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acthome);
    }
    public void retour(View arg0){
        setContentView(R.layout.activity_acthome);
    }
    public void ajques(View arg0){
        Intent intent = new Intent(acthome.this,new_q.class);
        startActivity(intent);
        acthome.this.finish();
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
    public void retours(View arg0){
        Intent intent = new Intent(acthome.this, generale.class);
        startActivity(intent);
        acthome.this.finish();
    }
}
