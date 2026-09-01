package com.example.intoy_mh3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final Button toClick = findViewById(R.id.loginButton);
        final TextView toSet = findViewById(R.id.username);
        final TextView toSetPassword = findViewById(R.id.password);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = toSet.getText().toString();
                String password = toSetPassword.getText().toString();

                if (userName.equals("admin") && password.equals("123")){
                    setContentView(R.layout.secondpage);
                    TextView greetingOnSecondPage = findViewById(R.id.greeting);
                    greetingOnSecondPage.setText("Welcome, " + userName + "!");

                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "Welcome, " + userName, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password!", Toast.LENGTH_LONG).show();
                }

            }
        });

        Toast.makeText(MainActivity.this, "Hello User!", Toast.LENGTH_LONG).show();
}
}