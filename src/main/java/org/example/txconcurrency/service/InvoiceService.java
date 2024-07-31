package org.example.txconcurrency.service;

import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.example.txconcurrency.dto.CreateInvoiceRequest;
import org.example.txconcurrency.entity.Invoice;
import org.example.txconcurrency.repository.InvoiceRepo;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepo invoiceRepo;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void upsert(CreateInvoiceRequest request) {
        Invoice invoice = invoiceRepo.findInvoiceByUuid(request.getUuid())
                .orElseGet(() -> Invoice.builder().amount(request.getAmount()).uuid(request.getUuid()).build());
        invoiceRepo.save(invoice);
    }
}
