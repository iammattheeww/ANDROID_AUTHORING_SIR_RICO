//package com.example.create_database_connection;
//
//import android.os.Bundle;
//import android.os.StrictMode;
//import android.view.View;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import android.widget.Button;
//import android.widget.TextView;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class MainActivity extends AppCompatActivity {
//    TextView myText;
//    Button myButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        myText = findViewById(R.id.textView);
//        myButton = findViewById(R.id.button2);
//
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//
//        myButton.setOnClickListener(new View.OnClickListener(){
//           @Override
//           public void onClick(View view){
//               toFetch();
//           }
//        });
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//
//    private void toFetch() {
//        try {
//            URL url = new URL("http://10.0.2.2/directory/androidselect.php");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuilder sb = new StringBuilder();
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                sb.append(line).append("\n");
//            }
//
//            reader.close();
//
//            myText.setText(sb.toString());
//
//        } catch (Exception e) {
//            myText.setText("Error: " + e.getMessage());
//        }
//    }
//}

package com.example.create_database_connection;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    TextView myResult;
    Button mySelect;
    Button btnInsert;
    Button btnDelete;
    Button btnUpdate;
    EditText getInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myResult = findViewById(R.id.dbSelect);
        mySelect = findViewById(R.id.btnSelect);
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        getInput = findViewById(R.id.myfname);
        // Allow network operation on main thread (for quick demo only)
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        mySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toFetch();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });
    }


    // ANDROID SELECT
    private void toFetch() {
        try {
            URL url = new URL("http://10.0.2.2/directory/androidselect.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            reader.close();

            myResult.setText(sb.toString());

        } catch (Exception e) {
            myResult.setText("Error: " + e.getMessage());
        }
    }

    // ANDROID INSERT
    private void insertData() {
        try {
            String fname = getInput.getText().toString().trim();

            URL url = new URL("http://192.168.1.11/androidinsert.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String postData = "fname=" + URLEncoder.encode(fname, "UTF-8");

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(postData);
            writer.flush();
            writer.close();
            os.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            myResult.setText(sb.toString());

        } catch (Exception e) {
            myResult.setText("Error: " + e.getMessage());
        }
    }

    // ANDROID DELETE
    private void deleteData() {
        try {
            String fname = getInput.getText().toString().trim();

            URL url = new URL("http://10.100.7.158/androiddelete.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String postData = "fname=" + URLEncoder.encode(fname, "UTF-8");

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(postData);
            writer.flush();
            writer.close();
            os.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            myResult.setText(sb.toString());

        } catch (Exception e) {
            myResult.setText("Error: " + e.getMessage());
        }
    }

    // ANDROID UPDATE
    private void updateData() {
        try {
            String fname = getInput.getText().toString().trim();

            if (fname.isEmpty()) {
                myResult.setText("Please enter a name to update.");
                return;
            }

            // Change to your actual local IP (same as your XAMPP server)
            URL url = new URL("http://10.100.7.158/androidupdate.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String postData = "fname=" + URLEncoder.encode(fname, "UTF-8");

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(postData);
            writer.flush();
            writer.close();
            os.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            myResult.setText(sb.toString());

        } catch (Exception e) {
            myResult.setText("Error: " + e.getMessage());
        }
    }
}

