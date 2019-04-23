package com.bangnd.batch.framework;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
public class Processor implements ItemProcessor<String, String> {
    @Override
    public String process(String data) throws Exception {
        return data;
    }
}