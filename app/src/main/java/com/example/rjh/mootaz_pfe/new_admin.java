package com.example.rjh.mootaz_pfe;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class new_admin extends AppCompatActivity {

        // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds

        public static final int CONNECTION_TIMEOUT=10000;
        public static final int READ_TIMEOUT=15000;
        private EditText etEmail;
        private EditText etPassword;
        private EditText etnom;
        private EditText etuser;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_admin);

            // Get Reference to variables
            etEmail = findViewById(R.id.email);
            etPassword = findViewById(R.id.password);
            etnom = findViewById(R.id.nom);
            etuser = findViewById(R.id.user);

        }

        // Triggers when LOGIN Button clicked
        public void register(View arg0) {

            // Get text from email and passord field
            final String email = etEmail.getText().toString();
            final String password = etPassword.getText().toString();
            final String nom = etnom.getText().toString();
            final String user = etuser.getText().toString();
            String role="admin";
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher em = p.matcher(email);
            if (email.isEmpty() || password.isEmpty() || user.isEmpty() || nom.isEmpty()){
                Toast.makeText(new_admin.this, "Email , nom , user ou mot de passe est vide",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            else if(!em.matches()) {

                Toast.makeText(new_admin.this, "Invalid Format d'email",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                new new_admin.Asyncregister().execute(email,password,user,nom,role);
            }

        }
        public void login(View arg0){
            Intent intent = new Intent(new_admin.this, login.class);
            startActivity(intent);
            new_admin.this.finish();
        }
    public void retour(View arg0){
        Intent intent = new Intent(new_admin.this, login.class);
        startActivity(intent);
        new_admin.this.finish();
    }
        @SuppressLint("StaticFieldLeak")
        private class Asyncregister extends AsyncTask<String, String, String>
        {
            ProgressDialog pdLoading = new ProgressDialog(new_admin.this);
            HttpURLConnection conn;
            URL url = null;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                //this method will be running on UI thread
                pdLoading.setMessage("\tLoading...");
                pdLoading.setCancelable(false);
                pdLoading.show();

            }
            @Override
            protected String doInBackground(String... params) {
                try {

                    // Enter URL address where your php file resides
                    url = new URL("http://10.0.2.2/mootaz_pfe/register.inc.php");

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return "exception";
                }
                try {
                    // Setup HttpURLConnection class to send and receive data from php and mysql
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setReadTimeout(READ_TIMEOUT);
                    conn.setConnectTimeout(CONNECTION_TIMEOUT);
                    conn.setRequestMethod("POST");

                    // setDoInput and setDoOutput method depict handling of both send and receive
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    // Append parameters to URL
                    Uri.Builder builder = new Uri.Builder()
                            .appendQueryParameter("email", params[0])
                            .appendQueryParameter("pass", params[1])
                            .appendQueryParameter("user", params[2])
                            .appendQueryParameter("nom", params[3])
                            .appendQueryParameter("role", params[4]);
                    String query = builder.build().getEncodedQuery();

                    // Open connection for sending data
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    os.close();
                    conn.connect();

                } catch (IOException e1) {
                    e1.printStackTrace();
                    return "exception";
                }

                try {

                    int response_code = conn.getResponseCode();

                    // Check if successful connection made
                    if (response_code == HttpURLConnection.HTTP_OK) {

                        // Read data sent from server
                        InputStream input = conn.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        StringBuilder result = new StringBuilder();
                        String line;

                        while ((line = reader.readLine()) != null) {
                            result.append(line);
                        }

                        // Pass data to onPostExecute method
                        return(result.toString());

                    }else{

                        return("unsuccessful");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return "exception";
                } finally {
                    conn.disconnect();
                }


            }

            @Override
            protected void onPostExecute(String result) {

                //this method will be running on UI thread

                pdLoading.dismiss();

                if(result.equalsIgnoreCase("true"))
                {
                    Intent intent = new Intent(new_admin.this,Home.class);
                    startActivity(intent);
                    new_admin.this.finish();
                }else if (result.equalsIgnoreCase("mail")){
                    Toast.makeText(new_admin.this, "Email déja utilisé", Toast.LENGTH_LONG).show();
                }else if (result.equalsIgnoreCase("user")){
                    Toast.makeText(new_admin.this, "User déja utilisé", Toast.LENGTH_LONG).show();
                }else if (result.equalsIgnoreCase("nom")){
                    Toast.makeText(new_admin.this, "Nom déja utilisé", Toast.LENGTH_LONG).show();
                }else if (result.equalsIgnoreCase("false")){
                    Toast.makeText(new_admin.this, "Invalid email or password", Toast.LENGTH_LONG).show();
                } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {
                    Toast.makeText(new_admin.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

