package com.code.random;

public class XOR {



    public static long randomLong(long seed) {
        seed ^= (seed << 21);
        seed ^= (seed >>> 35);
        seed ^= (seed << 4);
        System.out.println(seed);
        return seed;
    }
    public static void main(String[] args) {
//        long seed = System.nanoTime();
//        long l = randomLong(seed);
//        long l1 = randomLong(l);
//        long l2 = randomLong(l1);
        double random = Math.random();
        double random1 = Math.random();
        double random2 = Math.random();
        System.out.println(random);
        System.out.println(random1);
        System.out.println(random2);
    }
}
