package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo1 {
    public static void clear(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

        }catch (Exception e){

        }
    }
    public static void main(String[] args) {
        String time=getNowTime();
//        System.out.println(time);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                clear();
                String time=getNowTime();
//                System.out.println(time);
            }
        },1000, 1000);

    }

    private static String getNowTime() {
        Date data=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String t=format.format(data);
        return t;
    }
}
