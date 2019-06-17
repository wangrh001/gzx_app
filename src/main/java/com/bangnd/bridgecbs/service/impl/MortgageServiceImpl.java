package com.bangnd.bridgecbs.service.impl;

import com.bangnd.bridgecbs.entity.Mortgage;
import com.bangnd.bridgecbs.repository.MortgageRepository;
import com.bangnd.bridgecbs.service.MortgagePropertyTypeService;
import com.bangnd.bridgecbs.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class MortgageServiceImpl implements MortgageService {
    @Autowired
    private MortgageRepository mortgageRepository;
    @Autowired
    private MortgagePropertyTypeService mortgagePropertyTypeService;

    @Override
    public void save(Mortgage mortgage, Long orderId) {
        mortgage.setPropertyTypeName(mortgagePropertyTypeService.getOneById(mortgage.getPropertyType()).getName());
        mortgage.setOrderId(orderId);
        mortgage.setCreateTime(new Date());
        mortgage.setCreator(0);
        mortgageRepository.save(mortgage);
    }

    @Override
    public List<Mortgage> getAllByOrderId(Long orderId) {
        return mortgageRepository.findAllByOrderId(orderId);
    }

    @Override
    public Mortgage getOneById(Long id) {
        return mortgageRepository.findOneById(id);
    }

    @Override
    public void merge(Mortgage mortgage) {
        mortgageRepository.saveAndFlush(mortgage);
    }

    @Override
    public BigDecimal getTotalRegisterPrice(Long id) {
        BigDecimal totalRegisterPrice = new BigDecimal(0);
        List<Mortgage> mortgages= mortgageRepository.findAllByOrderId(id);
        if(mortgages !=null && mortgages.size()>0){
            for(Mortgage mortgage:mortgages){
                if(mortgage.getRegisterPrice()!=null){
                    totalRegisterPrice = totalRegisterPrice.add(mortgage.getRegisterPrice());
                }
            }
        }
        return totalRegisterPrice;
    }

    @Override
    public BigDecimal getTotalEstimatePrice(Long id) {
        BigDecimal totalEstimatePrice = new BigDecimal(0);
        List<Mortgage> mortgages= mortgageRepository.findAllByOrderId(id);
        if(mortgages !=null && mortgages.size()>0){
            for(Mortgage mortgage:mortgages){
                if(mortgage.getEstimatePrice()!=null){
                    totalEstimatePrice = totalEstimatePrice.add(mortgage.getEstimatePrice());
                }
            }
        }
        return totalEstimatePrice;
    }
}
