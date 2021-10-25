package com.engstrom.receiptapp.repositories;

import com.engstrom.receiptapp.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseRepository extends JpaRepository<Purchase, Long>{


}
