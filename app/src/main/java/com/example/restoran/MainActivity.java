package com.example.restoran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtn_menu(View view) {
        Intent i = new Intent(MainActivity.this, MenuMain.class);
        this.startActivity(i);
    }

    public void onBtn_pesanan(View view) {
        Intent i = new Intent(MainActivity.this, PesananActivity.class);
        this.startActivity(i);
    }
}
