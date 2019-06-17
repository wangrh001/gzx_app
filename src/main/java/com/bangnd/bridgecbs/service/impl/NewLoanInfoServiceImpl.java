package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.NewLoanInfo;
import com.bangnd.bridgecbs.repository.NewLoanInfoRepository;
import com.bangnd.bridgecbs.service.NewLoanConditionService;
import com.bangnd.bridgecbs.service.NewLoanInfoService;
import com.bangnd.util.service.OrganTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class NewLoanInfoServiceImpl implements NewLoanInfoService {
    @Autowired
    private NewLoanInfoRepository newLoanInfoRepository;

    @Autowired
    private OrganTypeService organTypeService;

    @Autowired
    private NewLoanConditionService newLoanConditionService;

    @Override
    public List<NewLoanInfo> getAllByOrderId(Long orderId) {
        return newLoanInfoRepository.findAllByOrderId(orderId);
    }

    @Override
    public NewLoanInfo getOneById(Long id) {
        return newLoanInfoRepository.findOneById(id);
    }

    @Override
    public void save(NewLoanInfo newLoanInfo,Long orderId) {
        newLoanInfo.setOrganTypeName(organTypeService.getOrganType(newLoanInfo.getOrganType()).getName());
        newLoanInfo.setLoanConditionName(newLoanConditionService.getOneById(newLoanInfo.getLoanCondition()).getName());
        newLoanInfo.setOrderId(orderId);
        newLoanInfo.setCreateTime(new Date());
        newLoanInfo.setCreator(0);
        newLoanInfo.setState(1);
        newLoanInfoRepository.save(newLoanInfo);
    }

    @Override
    public void merge(NewLoanInfo newLoanInfo) {
        newLoanInfoRepository.saveAndFlush(newLoanInfo);
    }

    @Override
    public BigDecimal getTotalApproveAmount(Long id) {
        BigDecimal totalApproveAmount = new BigDecimal(0);
        List<NewLoanInfo> newLoanInfos = newLoanInfoRepository.findAllByOrderId(id);
        if(newLoanInfos!=null && newLoanInfos.size()>0){
            for(NewLoanInfo newLoanInfo :newLoanInfos){
                if(newLoanInfo.getApproveAmount()!=null){
                    totalApproveAmount = totalApproveAmount.add(newLoanInfo.getApproveAmount());
                }
            }
        }
        return totalApproveAmount;
    }
}
