package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.CsworkCstype;
import com.bangnd.cs.repository.CsworkCstypeRepository;
import com.bangnd.cs.service.CsworkCstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CsworkCstypeServiceImpl implements CsworkCstypeService { 
@Autowired
private CsworkCstypeRepository csworkCstypeRepository;
@Override
public List<CsworkCstype> getAll(){return csworkCstypeRepository.findAll();}@Override
public CsworkCstype getCsworkCstypeById(int id){return csworkCstypeRepository.findOne(id);}}