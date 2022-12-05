package com.example.clienteandroidchat.Conexion;


import java.io.BufferedReader;
import java.util.Date;


public class HiloEscuchaServidor extends Thread{

    BufferedReader bufferedReader;

    String[]conectados;

    public HiloEscuchaServidor(BufferedReader bf){
        this.bufferedReader=bf;
    }

    @Override
    public void run(){

        String res;
        try {
            while ((res=bufferedReader.readLine())!=null){
            }
        }catch (Exception e){

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
