package com.example.clienteandroidchat.Conexion;


import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;


public class HiloEscrituraServidor extends Thread{

    public BufferedWriter bufferedWriter;
    String mensaje;

    public HiloEscrituraServidor(BufferedWriter bw,String msg){
        this.bufferedWriter=bw;
        this.mensaje=msg;
    }

    @Override
    public void run(){
        try {
            bufferedWriter.write(mensaje);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFecha(){
        String h,m,s;
        Date fecha= new Date();
        h=fixHora(fecha.getHours());
        m=fixHora(fecha.getMinutes());
        s=fixHora(fecha.getSeconds());

        return "["+h+":"+m+":"+s+"]";
    }

    public String fixHora(int num){
        String numero;
        if(num<10){
            numero= "0"+num;
        }else{
            numero= String.valueOf(num);
        }
        return numero;
    }

}
