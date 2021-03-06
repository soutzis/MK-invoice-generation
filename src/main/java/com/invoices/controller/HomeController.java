package com.invoices.controller;

import com.invoices.enumerations.InvoiceType;
import com.invoices.enumerations.IsApplicable;
import com.invoices.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

/**
 * This class is the controller responsible for handling requests for
 * actions like creating or deleting an invoice. It will map to the
 * appropriate controller method.
 * @author Petros Soutzis
 */
@Controller
public class HomeController {
    @Autowired private InvoiceService invoiceService;

    /**
     * Directs user to the home page.
     * @return The "HomePage"
     */
    @GetMapping("/")
    public String init(){

        return "initial.html";
    }

    /**
     *
     * @param model The Model component that will add content to the view
     * @param action What the user wants to do (i.e. update or delete an invoice)
     * @return The View based on what the user chose to do.
     */
    @GetMapping("/select/{action}")
    public String userSelection(Model model, @PathVariable("action") String action){
        model.addAttribute("invoices", invoiceService.getInvoices());
        model.addAttribute("noEnum", IsApplicable.NO);
        model.addAttribute("realEnum", InvoiceType.REAL);
        model.addAttribute("action", action);

        return "select-invoice-"+action+".html";
    }

    /**
     *
     * @param model The Model component that will add content to the view
     * @param result What action has the user completed
     * @return A page showing a success message to the user, about the action they just completed.
     */
    @GetMapping("/success/{result}")
    public String successMessage(Model model, @PathVariable("result") String result){
        model.addAttribute("result", result);

        return "success";
    }
}
