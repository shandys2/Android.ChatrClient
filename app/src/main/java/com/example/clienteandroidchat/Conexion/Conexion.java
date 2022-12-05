package com.example.clienteandroidchat.Conexion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Conexion {
    Socket socketChat;
    // String user="DANI";
    InputStream inputStreamChat;
    BufferedReader bufferedReaderChat;
    OutputStream outputStreamChat;
    BufferedWriter bufferedWriterChat;
    HiloEscuchaServidor hiloEscuchaServidorChat;

    public void iniciarSockets() throws IOException {

        socketChat=new Socket("localhost",5555);
        //Inicializacion de los streams del chat
        outputStreamChat= socketChat.getOutputStream();
        bufferedWriterChat = new BufferedWriter(new OutputStreamWriter(outputStreamChat));
        inputStreamChat= socketChat.getInputStream();
        bufferedReaderChat= new BufferedReader(new InputStreamReader(inputStreamChat));
        //Inicializacion del hilo de escucha del servidor
        hiloEscuchaServidorChat= new HiloEscuchaServidor(bufferedReaderChat);
        hiloEscuchaServidorChat.start();

     /*   //le metemos el username
        bufferedWriterChat.write(Cliente.nickName);
        bufferedWriterChat.newLine();
        bufferedWriterChat.flush();

*/
    }
}
