package com.example.test;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView myBottom = findViewById(R.id.myBottom);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v,insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       myBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              int id = menuItem.getItemId();
              if(id==R.id.home_id){
                  Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
              } else if (id==R.id.search_id){
                  Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
              } else if (id==R.id.favorites){
                  Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
              }
              else if (id==R.id.profile){
                  Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
              }
               return true;
           }
       });

        Toast.makeText(MainActivity.this, "Hello User!", Toast.LENGTH_LONG).show();
    }
}