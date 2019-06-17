package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.OriginalLoanInfo;
import com.bangnd.bridgecbs.repository.OriginalLoanInfoRepository;
import com.bangnd.bridgecbs.service.*;
import com.bangnd.util.service.OrganTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Service
public class OriginalLoanInfoServiceImpl implements OriginalLoanInfoService {
    @Autowired
    private OriginalLoanInfoRepository originalLoanInfoRepository;
    @Autowired
    private OrganTypeService organTypeService;
    @Autowired
    private OriginalLoanTypeService originalLoanTypeService;
    @Autowired
    private BridgeOrderAcceptionBankCodeService bridgeOrderAcceptionBankCodeService;
    @Autowired
    private OriginalLoanForeclosureTypeService originalLoanForeclosureTypeService;

    @Override
    public List<OriginalLoanInfo> getAllByOrderId(Long orderId) {
        return originalLoanInfoRepository.findAllByOrderId(orderId);
    }

    @Override
    public OriginalLoanInfo getOneById(Long id) {
        return originalLoanInfoRepository.findOneById(id);
    }

    @Override
    public void save(OriginalLoanInfo originalLoanInfo,Long orderId) {

        originalLoanInfo.setTypeName(originalLoanTypeService.getOneById(originalLoanInfo.getType()).getName());
        originalLoanInfo.setOrganTypeName(organTypeService.getOrganType(originalLoanInfo.getOrganType()).getName());
        originalLoanInfo.setOrganCodeName(bridgeOrderAcceptionBankCodeService.getBridgeOrderAcceptionBankCodeById(originalLoanInfo.getBankCode()).getName());
        originalLoanInfo.setForeclosureTypeName(originalLoanForeclosureTypeService.getOneById(originalLoanInfo.getForeclosureType()).getName());
        originalLoanInfo.setOrderId(orderId);
        originalLoanInfo.setCreateTime(new Date());
        originalLoanInfo.setCreator(0);
        originalLoanInfoRepository.save(originalLoanInfo);
    }

    @Override
    public void merge(OriginalLoanInfo originalLoanInfo) {
        originalLoanInfoRepository.saveAndFlush(originalLoanInfo);
    }

    @Override
    public BigDecimal getTotalLoanAmount(Long id) {
        BigDecimal totalLoanAmount = new BigDecimal(0);
        List<OriginalLoanInfo> originalLoanInfos= originalLoanInfoRepository.findAllByOrderId(id);
        if(originalLoanInfos !=null && originalLoanInfos.size()>0){
            for(OriginalLoanInfo originalLoanInfo:originalLoanInfos){
                if(originalLoanInfo.getAmount()!=null){
                    totalLoanAmount = totalLoanAmount.add(originalLoanInfo.getAmount());
                }
            }
        }
        return totalLoanAmount;
    }

    @Override
    public BigDecimal getTotalCaptialInterest(Long id) {
        BigDecimal totalCaptialInterest = new BigDecimal(0);
        List<OriginalLoanInfo> originalLoanInfos= originalLoanInfoRepository.findAllByOrderId(id);
        if(originalLoanInfos !=null && originalLoanInfos.size()>0){
            for(OriginalLoanInfo originalLoanInfo:originalLoanInfos){
                if(originalLoanInfo.getCapitalInterest()!=null){
                    totalCaptialInterest = totalCaptialInterest.add(originalLoanInfo.getCapitalInterest());
                }
            }
        }
        return totalCaptialInterest;
    }
}
