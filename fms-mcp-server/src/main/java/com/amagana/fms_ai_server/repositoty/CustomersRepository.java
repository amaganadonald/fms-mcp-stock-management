package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> findByCode(String code);
}
