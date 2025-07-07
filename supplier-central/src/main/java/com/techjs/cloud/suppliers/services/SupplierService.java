package com.techjs.cloud.suppliers.services;

import com.techjs.cloud.suppliers.entities.Supplier;
import com.techjs.cloud.suppliers.repositories.SupplierRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier createSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Cacheable("suppliers")
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    public Optional<Supplier> getSupplierById(Integer id) {
        return repository.findById(id);
    }

    public Supplier updateSupplier(Integer id, Supplier updated) {
        return repository.findById(id)
            .map(s -> {
                s.setName(updated.getName());
                s.setActive(updated.isActive());
                s.setTrustRating(updated.getTrustRating());
                return repository.save(s);
            })
            .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public void deleteSupplier(Integer id) {
        repository.deleteById(id);
    }
}
