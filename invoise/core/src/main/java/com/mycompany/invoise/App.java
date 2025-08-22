package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceController;
import com.mycompany.invoise.controller.InvoiceControllerChambouleToutMagasin2;
import com.mycompany.invoise.controller.InvoiceControllerMichel;
import com.mycompany.invoise.repository.InvoiceRepository;
import com.mycompany.invoise.repository.InvoiceRepositoryMichel;
import com.mycompany.invoise.service.InvoiceService;
import com.mycompany.invoise.service.InvoiceServiceMichel;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dans quelle configuration êtes-vous ?");
        int configuration = sc.nextInt();

        if (configuration == 1) {
            InvoiceController invoiceController = new InvoiceController();

            InvoiceService invoiceService = new InvoiceService();
            invoiceController.setInvoiceService(invoiceService);

            InvoiceRepository invoiceRepository = new InvoiceRepository();
            invoiceService.setInvoiceRepository(invoiceRepository);

            invoiceController.createInvoice();
        } else if (configuration == 2) {
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();

            InvoiceServiceMichel invoiceServiceMichel = new InvoiceServiceMichel();
            invoiceControllerMichel.setInvoiceService(invoiceServiceMichel);

            InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();
            invoiceServiceMichel.setInvoiceRepositoryMichel(invoiceRepositoryMichel);

            invoiceControllerMichel.createInvoice();
        } else if (configuration == 3) { // magasin 1
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();

            InvoiceService invoiceService = new InvoiceService();
            invoiceControllerMichel.setInvoiceService(invoiceService);

            InvoiceRepositoryMichel invoiceRepositoryMichel = new  InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepositoryMichel);

            invoiceControllerMichel.createInvoice();
        } else if (configuration == 4) { // magasin 2
            InvoiceControllerChambouleToutMagasin2 invoiceControllerChambouleToutMagasin2 = new InvoiceControllerChambouleToutMagasin2();

            InvoiceService invoiceService = new InvoiceService();
            invoiceControllerChambouleToutMagasin2.setInvoiceService(invoiceService);

            InvoiceRepositoryMichel invoiceRepositoryMichel = new  InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepositoryMichel);

            invoiceControllerChambouleToutMagasin2.createInvoice();
        }
    }
}
