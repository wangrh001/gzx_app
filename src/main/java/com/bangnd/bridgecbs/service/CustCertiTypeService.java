package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.CustCertiType;

import java.util.List;

public interface CustCertiTypeService {
    public List<CustCertiType> getAll();
    public CustCertiType getCertiTypeById(int id);
}
