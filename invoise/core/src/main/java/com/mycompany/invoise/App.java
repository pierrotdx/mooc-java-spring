package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new SpringApplication(App.class).run(args);
        InvoiceControllerInterface invoiceController = context.getBean(InvoiceControllerInterface.class);
        invoiceController.createInvoice();
    }
}
