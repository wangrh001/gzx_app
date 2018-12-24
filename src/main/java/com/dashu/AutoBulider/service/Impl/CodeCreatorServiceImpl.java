package com.dashu.AutoBulider.service.Impl;

import com.dashu.AutoBulider.repository.DataModelRepository;
import com.dashu.AutoBulider.service.CodeCreatorService;
import org.springframework.beans.factory.annotation.Autowired;

public class CodeCreatorServiceImpl implements CodeCreatorService {
    @Autowired
    DataModelRepository dataModelRepository;

    @Override
    public String createControllerCode(String eneity) {
        return null;
    }

    @Override
    public String createServiceCode(String eneity) {
        return null;
    }

    @Override
    public String createServiceImplCode(String eneity) {
        return null;
    }

    @Override
    public String createRepositoryCode(String eneity) {
        return null;
    }

    @Override
    public String createEntityCode(String eneity) {
        return null;
    }

    @Override
    public String createVOCode(String eneity) {
        return null;
    }

    @Override
    public String createFormCode(String eneity) {
        return null;
    }

    @Override
    public String createHtmlCode(String eneity) {
        return null;
    }
}
