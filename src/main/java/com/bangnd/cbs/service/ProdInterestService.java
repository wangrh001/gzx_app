package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.ProdInterest;
import com.bangnd.cbs.form.ProdInterestSearchForm;
import org.springframework.data.domain.Page;

public interface ProdInterestService {
    public Page<ProdInterest> getProdInterestList(Integer pageNum, int size, ProdInterestSearchForm prodInterestSearchForm);

    public void save(ProdInterest prodInterest);

    public ProdInterest getProdInterestById(long id);

    public void merge(ProdInterest prodInterest);
}