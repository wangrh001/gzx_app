package com.bangnd.batch.framework;

import com.bangnd.batch.jobs.cbs.LoanApproveReaderJob;
import com.bangnd.batch.jobs.cbs.ReminderJob;
import com.bangnd.batch.jobs.hr.SyncDDEmployeeAndDept;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reader implements ItemReader<String> {

    @Autowired
    LoanApproveReaderJob loanApproveReaderJob;
    @Autowired
    ReminderJob reminderJob;
    @Autowired
    SyncDDEmployeeAndDept syncDDEmployeeAndDept;

    private int count=0;
    @Override
    public String read() throws Exception {
        System.out.println("enter the process");
        List<String> approveList=loanApproveReaderJob.process();
        reminderJob.process();
        //syncDDEmployeeAndDept.process();
        if(count>=1){
            count++;
            return approveList.toString();
        }else{
            count=0;
        }
        return null;
    }
}