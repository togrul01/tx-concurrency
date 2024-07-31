package org.example.txconcurrency.repository;

import org.example.txconcurrency.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepo extends JpaRepository<Invoice,Long> {

    Optional<Invoice> findInvoiceByUuid(String uuid);
}
