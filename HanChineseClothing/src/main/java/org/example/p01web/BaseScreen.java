package org.example.p01web;

public class BaseScreen {
    //清屏
    public static void clear(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

        }catch (Exception e){

        }
    }

}
