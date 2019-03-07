package com.bangnd.cs.service.impl;
import  com.bangnd.cs.entity.*;
import  com.bangnd.cs.service.*;
import  com.bangnd.cs.repository.*;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CsworkCsStateServiceImpl implements CsworkCsStateService { 
@Autowired
private CsworkCsStateRepository csworkCsStateRepository;
@Override
public List<CsworkCsState> getAll(){return csworkCsStateRepository.findAll();}@Override
public CsworkCsState getCsworkCsStateById(int id){return csworkCsStateRepository.findOne(id);}}