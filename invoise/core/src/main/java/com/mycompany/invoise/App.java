package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;

import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import com.mycompany.invoise.service.prefix.InvoiceServicePrefix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.mycompany.invoise.repository.memory", /*"com.mycompany.invoise.service.prefix",*/ "com.mycompany.invoise.controller.web"})
@PropertySource("classpath:application.properties")
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        InvoiceControllerInterface invoiceController = context.getBean(InvoiceControllerInterface.class);
        invoiceController.createInvoice();
    }

    @Bean
    public InvoiceServiceInterface configureInvoiceService(InvoiceRepositoryInterface repositoryInterface) {
        return new InvoiceServicePrefix(repositoryInterface);
    }
}
