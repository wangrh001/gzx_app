package com.bangnd.finance.form;

import javax.persistence.*;
import java.util.*;

public class AccountingRuleSearchForm {
    @Column
    public String feeType;

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
}