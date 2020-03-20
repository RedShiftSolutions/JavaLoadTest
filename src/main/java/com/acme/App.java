package com.acme;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        ArrayList<Integer> primes = new ArrayList<Integer>();

        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);

        int retVal = 0;

        for (int i = 0; i < args.length; i++) {
            try {
                int value = Integer.parseInt(args[i]);
                if (!primes.contains(value)) {
                    retVal = 1;
                }
            } catch (Exception e) {
                retVal = 2;
            }
            System.out.println(args[i]);
        }
        System.exit(retVal);
    }
}
