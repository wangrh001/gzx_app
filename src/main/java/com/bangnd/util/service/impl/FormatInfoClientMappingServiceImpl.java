package com.bangnd.util.service.impl;

import com.bangnd.util.entity.FormatInfoClientMapping;
import com.bangnd.util.repository.FormatInfoClientMappingRepository;
import com.bangnd.util.service.FormatInfoClientMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatInfoClientMappingServiceImpl implements FormatInfoClientMappingService {

    @Autowired
    FormatInfoClientMappingRepository formatInfoClientMappingRepository;
    @Override
    public String getFormatInfoKeyByClientKeyAndType(String clientKey, int ocrType) {
         FormatInfoClientMapping formatInfoClientMapping = formatInfoClientMappingRepository.findByClientKeyAndType(clientKey,ocrType);
         if(formatInfoClientMapping!=null){
             return formatInfoClientMapping.getFormatInfoKey();
         }
         return null;
    }
}
