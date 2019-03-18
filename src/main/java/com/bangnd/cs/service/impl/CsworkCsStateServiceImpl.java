package com.bangnd.cs.service.impl;

import com.bangnd.cs.entity.CsworkCsState;
import com.bangnd.cs.repository.CsworkCsStateRepository;
import com.bangnd.cs.service.CsworkCsStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CsworkCsStateServiceImpl implements CsworkCsStateService { 
@Autowired
private CsworkCsStateRepository csworkCsStateRepository;
@Override
public List<CsworkCsState> getAll(){return csworkCsStateRepository.findAll();}@Override
public CsworkCsState getCsworkCsStateById(int id){return csworkCsStateRepository.findOne(id);}}