package com.techjs.cloud.suppliers.repositories;

import com.techjs.cloud.suppliers.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
