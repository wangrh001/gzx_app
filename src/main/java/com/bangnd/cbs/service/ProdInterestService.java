package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.ProdInterest;
import com.bangnd.cbs.form.ProdInterestSearchForm;

import java.util.List;

public interface ProdInterestService {
    public List<ProdInterest> getProdInterestList(ProdInterestSearchForm prodInterestSearchForm);

    public void save(ProdInterest prodInterest);

    public ProdInterest getProdInterestById(long id);

    public void merge(ProdInterest prodInterest);
}