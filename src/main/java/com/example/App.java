package com.example;

import io.javalin.Javalin; //framework para tener app web

/**
 * Hello world!
 *
 */
public class App {
    //metodo para inicializar servidor de javalin
    public static Javalin createApp(){
        return Javalin.create().get("/hello", ctx -> ctx.result("Hello World"));
    }

    public static void main(String[] args){
        createApp().start(7000);
    }
}
