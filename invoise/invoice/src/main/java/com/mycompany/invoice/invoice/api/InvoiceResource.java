package com.mycompany.invoice.invoice.api;

import com.mycompany.invoice.invoice.service.InvoiceServiceInterface;
import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
//
//    @PostMapping
//    public Invoice create(@RequestBody Invoice invoice) {
//        this.invoiceService.createInvoice(invoice);
//        return invoice;
//    }

    @GetMapping
    public ParallelFlux<Invoice> list() {
        System.out.println("La méthode displayHomFe() a été invoquée.");

        List<Mono<Invoice>> invoiceMono = new ArrayList<>();

        final WebClient webClient = this.webClientBuilder.baseUrl("http://customer-service").build();

        Iterable<Invoice> invoices = this.invoiceService.getInvoiceList();
        for (Invoice invoice : invoices) {
            invoiceMono.add(webClient
                    .get()
                    .uri("/customer/" + invoice.getIdCustomer())
                    .retrieve()
                    .bodyToMono(Customer.class)
                    .map((customer) -> {
                        invoice.setCustomer(customer);
                        return invoice;
                    })
            );
//            invoice.setCustomer(restTemplate.getForObject("http://customer-service/customer/" + invoice.getIdCustomer(), Customer.class));
        }
        final Flux<Invoice> invoiceFlux = Flux.concat(invoiceMono);
        return invoiceFlux.parallel().runOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        Invoice invoice = this.invoiceService.getInvoiceByNumber(number);
        final WebClient webClient = this.webClientBuilder.baseUrl("http://customer-service").build();
        final Customer customer = webClient
                .get()
                .uri("/customer/" + invoice.getIdCustomer())
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
        final Address address = webClient.get().uri("/address/" + + customer.getAddress().getId()).retrieve().bodyToMono(Address.class).block();
        customer.setAddress(address);
        invoice.setCustomer(customer);
        System.out.println("La méthode displayInvoice() a été invoquée.");
        return invoice;
    }

//    @GetMapping("/create-form")
//    public String displayCreateForm(@ModelAttribute InvoiceForm invoice) {
//        return "invoice-create-form";
//    }


    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WebClient.Builder getWebClientBuilder() {
        return webClientBuilder;
    }

    public void setWebClientBuilder(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
}
