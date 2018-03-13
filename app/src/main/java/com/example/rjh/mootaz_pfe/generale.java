package com.example.rjh.mootaz_pfe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class generale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generale);
    }
    public void retour(View arg0){

        setContentView(R.layout.activity_generale);
    }
    public void refresh(View arg0){
        WebView myWebView=findViewById(R.id.wbvw);
        myWebView.reload();
    }
    public void convert(View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("CONVERTISSEUR DE DEVISES");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/convert.html");
    }
    public void rapport(View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("Rapports annuels");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/rapport.html");
    }
    public void cours(View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("COURS DE CHANGE");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/cours.html");
    }
    public void simcredit(View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("Simulation de crédit");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/simcredit.html");
    }
    public void simplacement(View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("Simulation de placement");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/simplacement.html");
    }
    public void bank(View arg0){
        setContentView(R.layout.generale);
        WebView myWebView=findViewById(R.id.wbvw);
        Button btn=findViewById(R.id.button);
        btn.setText("LA BANQUE EN BREF");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://10.0.2.2/mootaz_pfe/bank.html");

    }
    public void exit(View arg0){
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
        finish();
        System.exit(0);
    }
    public void avis(View arg0){
        Intent intent = new Intent(generale.this, acthome.class);
        // If you just use this that is not a valid context. Use ActivityName.this
        startActivity(intent);
        generale.this.finish();
    }
}
