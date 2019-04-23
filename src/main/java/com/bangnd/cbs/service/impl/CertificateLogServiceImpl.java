package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.CertificateLog;
import com.bangnd.cbs.repository.CertificateLogRepository;
import com.bangnd.cbs.service.CertificateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateLogServiceImpl implements CertificateLogService {

    @Autowired
    CertificateLogRepository certificateLogRepository;
    @Override
    public void save(CertificateLog certificateLog) {
        certificateLogRepository.save(certificateLog);
    }
}
