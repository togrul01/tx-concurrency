package org.example.txconcurrency.controller;

import lombok.RequiredArgsConstructor;
import org.example.txconcurrency.dto.CreateInvoiceRequest;
import org.example.txconcurrency.service.InvoiceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping
    public void upsert(@RequestBody CreateInvoiceRequest request) {
        invoiceService.upsert(request);

    }
}
