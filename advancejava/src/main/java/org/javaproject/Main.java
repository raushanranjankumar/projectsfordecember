package org.javaproject;

public class Main {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            String str = "Raushan";
            for(char ch : str.toCharArray()){
                System.out.print(ch);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
    }
}