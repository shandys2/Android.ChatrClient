package com.example.clienteandroidchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.clienteandroidchat.Conexion.ConexionServer;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    Button btnEnviar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView=findViewById(R.id.txtMensaje);
        this.btnEnviar=findViewById(R.id.btnEnviar);

        ConexionServer asyncTasks= (ConexionServer) new ConexionServer(btnEnviar,textView).execute("");


        MensajeItemFragment fragment = new MensajeItemFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();


    }

}