package com.acme;

public class App 
{
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.exit(1);
    }
}
