package com.bangnd.bridgecbs.repository;

import com.bangnd.bridgecbs.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    @Query("select b from BankAccount b where b.orderId =:orderId and b.type = :accountType and b.state = 1")
    public List<BankAccount> findAllByOrderIdAndType(@Param(value = "orderId") Long orderId,
                                                     @Param(value = "accountType") int type);

    @Query("select b from BankAccount b where b.id=:id and b.state <> 100")
    public BankAccount findBankAccountById(@Param(value = "id") Long id);
}
