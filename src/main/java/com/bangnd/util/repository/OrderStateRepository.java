package com.bangnd.util.repository;

import com.bangnd.util.entity.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStateRepository extends JpaRepository<OrderState, Long> {
}
