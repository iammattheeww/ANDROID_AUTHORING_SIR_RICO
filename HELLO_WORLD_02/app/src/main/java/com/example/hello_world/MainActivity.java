package com.example.hello_world;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final Button toClick = findViewById(R.id.button2);
//        final TextView myText = findViewById(R.id.myTextView);
//        final TextView toSet = findViewById(R.id.email);
        final TextView toSet = findViewById(R.id.name);
//        final TextView toSet = findViewById(R.id.password);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        toClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String toGet = toSet.getText().toString();
//                myText.setText(toGet);
//            }
//        });

        toClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Get the name from the input field before changing layouts
                String userName = toSet.getText().toString();

                // 2. Switch to the second page layout first
                setContentView(R.layout.secondpage);

                // 3. Find the TextView on the SECOND page layout
                // (Make sure R.id.secondPageGreeting matches the ID in your secondpage.xml)
                TextView greetingOnSecondPage = findViewById(R.id.greeting);

                // 4. Set the welcome message with the user's name
                greetingOnSecondPage.setText("Welcome, " + userName + "!");

                // IMAGE VIEW
                final ImageView imageView = findViewById(R.id.burgerking);
            }
        });

        Toast.makeText(MainActivity.this, "Hello User!", Toast.LENGTH_LONG).show();
    }
}