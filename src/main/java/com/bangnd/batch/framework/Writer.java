package com.bangnd.batch.framework;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> messages) throws Exception {
        for (String msg : messages) {
            System.out.println("输出信息：" + msg);
        }

    }
}