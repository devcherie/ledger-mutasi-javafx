package com.service;

public class BackgroundService
        implements Runnable {

    @Override
    public void run() {

        try {

            while (true) {

                System.out.println(
                        "Monitoring Data..."
                );

                Thread.sleep(5000);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}