package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.BridgeOrderChannelType;
import com.bangnd.bridgecbs.repository.BridgeOrderChannelTypeRepository;
import com.bangnd.bridgecbs.service.BridgeOrderChannelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeOrderChannelTypeServiceImpl implements BridgeOrderChannelTypeService {
    @Autowired
    private BridgeOrderChannelTypeRepository bridgeOrderChannelTypeRepository;

    @Override
    public List<BridgeOrderChannelType> getAll() {
        return bridgeOrderChannelTypeRepository.findAll();
    }
}
