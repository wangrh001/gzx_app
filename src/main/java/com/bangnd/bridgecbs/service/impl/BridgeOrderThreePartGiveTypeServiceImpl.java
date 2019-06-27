package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.BridgeOrderThreePartGiveType;
import com.bangnd.bridgecbs.repository.BridgeOrderThreePartGiveTypeRepository;
import com.bangnd.bridgecbs.service.BridgeOrderThreePartGiveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeOrderThreePartGiveTypeServiceImpl implements BridgeOrderThreePartGiveTypeService {
    @Autowired
    private BridgeOrderThreePartGiveTypeRepository bridgeOrderThreePartGiveTypeRepository;

    @Override
    public List<BridgeOrderThreePartGiveType> getAll() {
        return bridgeOrderThreePartGiveTypeRepository.findAll();
    }
}
