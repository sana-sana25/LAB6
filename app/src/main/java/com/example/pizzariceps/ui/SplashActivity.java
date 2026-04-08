package com.example.pizzariceps.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzariceps.R;

public class SplashActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_splash);

        new Thread(() -> {
            try { Thread.sleep(2000); } catch (Exception e) {}
            startActivity(new Intent(this, ListPizzaActivity.class));
            finish();
        }).start();
    }
}