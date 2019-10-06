package com.example.tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Async_act extends AppCompatActivity {

    private EditText et1, et2;
    private ProgressBar pb;
    private Button btn;

    String usuario = "esteban";
    String password = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_act);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        pb  =  (ProgressBar)findViewById(R.id.pb);
        btn =  (Button)findViewById(R.id.btn);

        pb.setVisibility(View.INVISIBLE); // haciendo invisible el programa

        //el boton va a escuchar la accion que deseo realizar
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // colocar la tarea
                new Task().execute(et1.getText().toString()); // ejecuto mi tarea asincrona
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
            btn.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {

            try{
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            String nombreUsuario = et1.getText().toString();
            String passwordUsuario = et2.getText().toString();

            if(nombreUsuario.equals(usuario) && passwordUsuario.equals(password)) {
                Toast.makeText(getBaseContext(), "Acceso Concedido", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Acceso Denegado", Toast.LENGTH_LONG).show();
            }

        }
    }


}
