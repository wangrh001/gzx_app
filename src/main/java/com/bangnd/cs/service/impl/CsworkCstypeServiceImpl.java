package com.bangnd.cs.service.impl;
import  com.bangnd.cs.entity.*;
import  com.bangnd.cs.service.*;
import  com.bangnd.cs.repository.*;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CsworkCstypeServiceImpl implements CsworkCstypeService { 
@Autowired
private CsworkCstypeRepository csworkCstypeRepository;
@Override
public List<CsworkCstype> getAll(){return csworkCstypeRepository.findAll();}@Override
public CsworkCstype getCsworkCstypeById(int id){return csworkCstypeRepository.findOne(id);}}