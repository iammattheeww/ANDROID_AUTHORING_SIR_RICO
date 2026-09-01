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

        // ==========================================
        // STEP-BY-STEP CALCULATOR IMPLEMENTATION GUIDE:
        // ==========================================
        // Step 1: In your activity_main.xml, add:
        //         - Two PlainText (EditText) views for input numbers (e.g., id: @+id/inputNum1, @+id/inputNum2)
        //         - One Button to trigger the calculation (e.g., id: @+id/calcButton)
        //         - One TextView to display the result (e.g., id: @+id/resultTextView)
        //
        // Step 2: Initialize those UI components inside onCreate() like below:
        // final EditText num1 = findViewById(R.id.inputNum1);
        // final EditText num2 = findViewById(R.id.inputNum2);
        // final Button calcButton = findViewById(R.id.calcButton);
        // final TextView resultView = findViewById(R.id.resultTextView);
        //
        // Step 3: Set up an OnClickListener for your calculator button:
        // calcButton.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         // Step 4: Extract text from EditText fields and check if they are empty
        //         String s1 = num1.getText().toString();
        //         String s2 = num2.getText().toString();
        //
        //         if (!s1.isEmpty() && !s2.isEmpty()) {
        //             // Step 5: Convert String inputs to numeric values (double or int)
        //             double n1 = Double.parseDouble(s1);
        //             double n2 = Double.parseDouble(s2);
        //
        //             // Step 6: Perform the math operation (e.g., Addition)
        //             double sum = n1 + n2;
        //
        //             // Step 7: Display the calculated result on the TextView
        //             resultView.setText("Result: " + sum);
        //         } else {
        //             // Show a warning if inputs are blank
        //             Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
        //         }
        //     }
        // });
        // ==========================================
    }
}