package com.bangnd.util.service.impl;

import com.bangnd.util.entity.YesOrNo;
import com.bangnd.util.repository.YesOrNoRepository;
import com.bangnd.util.service.YesOrNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YesOrNoServiceImpl implements YesOrNoService {
    @Autowired
    private YesOrNoRepository yesOrNoRepository;

    @Override
    public List<YesOrNo> getAll() {
        return yesOrNoRepository.findAll();
    }
}
