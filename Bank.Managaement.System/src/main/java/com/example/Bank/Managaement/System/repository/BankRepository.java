package com.example.Bank.Managaement.System.repository;

import com.example.Bank.Managaement.System.model.AxisBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<AxisBank,Long> {
}
