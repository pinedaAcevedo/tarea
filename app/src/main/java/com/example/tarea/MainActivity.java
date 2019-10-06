package com.example.tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Intent Explicito
    public void Asynck(View v)
    {
        Intent i = new Intent(this, Async_act.class);
        startActivity(i);
    }

    public void Segundos(View view) {

        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep( 1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void Hilos(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try
                {
                    for(int i =0; i>10; i++)
                    {
                        Thread.sleep(1000);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "Hello world", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}


