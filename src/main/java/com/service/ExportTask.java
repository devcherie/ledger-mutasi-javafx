package com.service;

import javafx.concurrent.Task;

public class ExportTask extends Task<Void> {

    @Override
    protected Void call() throws Exception {

        for(int i = 0; i <= 100; i++) {

            updateProgress(i, 100);

            Thread.sleep(20);
        }

        return null;
    }
}