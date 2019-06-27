package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.BridgeOrderChannelFollowType;
import com.bangnd.bridgecbs.repository.BridgeOrderChannelFollowTypeRepository;
import com.bangnd.bridgecbs.service.BridgeOrderChannelFollowTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeOrderChannelFollowTypeServiceImpl implements BridgeOrderChannelFollowTypeService {
    @Autowired
    private BridgeOrderChannelFollowTypeRepository bridgeOrderChannelFollowTypeRepository;

    @Override
    public List<BridgeOrderChannelFollowType> getAll() {
        return bridgeOrderChannelFollowTypeRepository.findAll();
    }
}
