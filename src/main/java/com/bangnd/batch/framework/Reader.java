package com.bangnd.batch.framework;

import com.bangnd.batch.jobs.client.LoanApproveReaderJob;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reader implements ItemReader<String> {

    @Autowired
    LoanApproveReaderJob loanApproveReaderJob;

    private int count=0;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("enter the process");
        List<String> approveList=loanApproveReaderJob.process();
        if(count>=1){
            count++;
            return approveList.toString();
        }else{
            count=0;
        }
        return null;
    }
}