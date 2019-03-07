package com.bangnd.cbs.service;

import java.util.Random;

public class RandomNumberCreator {
    public static void main(String[] args) {
        RandomNumberCreator randomNumberCreator = new RandomNumberCreator();
        Random random = new Random();
//        random.setSeed(1);
        float sum = 0;
        double sum1 = 0;
        int m = 0;
        for (int i = 0; i < 1000000; i++) {
            int n = random.nextInt(10000000);
//            System.out.println(n);

            if (n < 100) {
                m++;
                System.out.println("Cong!!!");
            }
        }
        System.out.println(m);
    }
}
