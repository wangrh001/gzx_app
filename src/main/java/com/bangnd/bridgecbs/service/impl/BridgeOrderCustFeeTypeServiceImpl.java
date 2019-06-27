package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.BridgeOrderCustFeeType;
import com.bangnd.bridgecbs.repository.BridgeOrderCustFeeTypeRepository;
import com.bangnd.bridgecbs.service.BridgeOrderCustFeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeOrderCustFeeTypeServiceImpl implements BridgeOrderCustFeeTypeService {
    @Autowired
    private BridgeOrderCustFeeTypeRepository bridgeOrderCustFeeTypeRepository;

    @Override
    public List<BridgeOrderCustFeeType> getAll() {
        return bridgeOrderCustFeeTypeRepository.findAll();
    }
}
