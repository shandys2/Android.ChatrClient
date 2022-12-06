package com.example.clienteandroidchat.Conexion;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ConexionServer extends AsyncTask<String, Void, Void> {

    Socket socketChat;
    // String user="DANI";
    InputStream inputStreamChat;
    BufferedReader bufferedReaderChat;
    OutputStream outputStreamChat;
    static BufferedWriter bufferedWriterChat;
    HiloEscuchaServidor hiloEscuchaServidor;

    Button btnEnviar;
    TextView textView;


    public ConexionServer(Button btn, TextView txt ){
        this.btnEnviar=btn;
        this.textView=txt;

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             HiloEscrituraServidor escrituraServidor= new HiloEscrituraServidor(bufferedWriterChat, String.valueOf(textView.getText()));
             escrituraServidor.start();

            }
        });
    }

    protected Void doInBackground(String... urls) {
        try {


            socketChat=new Socket("10.0.2.2",5555);
            //Inicializacion de los streams del chat
            outputStreamChat= socketChat.getOutputStream();
            bufferedWriterChat = new BufferedWriter(new OutputStreamWriter(outputStreamChat));
            inputStreamChat= socketChat.getInputStream();
            bufferedReaderChat= new BufferedReader(new InputStreamReader(inputStreamChat));
            //Inicializacion del hilo de escucha del servidor
            hiloEscuchaServidor= new HiloEscuchaServidor(bufferedReaderChat);
            hiloEscuchaServidor.start();

            //le metemos el username
            bufferedWriterChat.write("ANDROIDE");
            bufferedWriterChat.newLine();
            bufferedWriterChat.flush();


        } catch (Exception e) {
            Log.i("LA EXCEPCION", e.getMessage());
            return null;
        } finally {

        }
        return null;
    }

    protected void onPostExecute() {

    }

    public void iniciarSockets() throws IOException, IOException {

    }
}