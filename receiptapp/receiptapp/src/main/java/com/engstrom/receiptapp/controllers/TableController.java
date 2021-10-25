package com.engstrom.receiptapp.controllers;

import com.engstrom.receiptapp.models.PatientTotal;
import com.engstrom.receiptapp.models.Purchase;
import com.engstrom.receiptapp.repositories.PurchaseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@Controller
public class TableController {

    private PurchaseRepository purchaseRepo;

    @GetMapping
    public String index(Model model){
        List<Purchase> purchases = purchaseRepo.findAll();
        model.addAttribute("purchases", purchases);

        int purchaseSum = 0;
        for(Purchase p : purchases){
            purchaseSum += p.getPrice();
        }
        PatientTotal total = new PatientTotal(purchaseSum);
        model.addAttribute("patientTotal", total.getTotal());

        return "index";
    }

    public void savePurchase(Purchase purchase){
            this.purchaseRepo.save(purchase);
    }

    @GetMapping("/addPurchase")
    public String addPurchasePage(Model model){
        Purchase purchase = new Purchase();
        model.addAttribute("purchase", purchase);
        return "addPurchase";
    }

    @PostMapping("/addPurchase")
    public String addPurchase(@ModelAttribute("purchase") Purchase purchase){
            savePurchase(purchase);
            return "redirect:/";
    }

    public void deletePurchaseById(long id) {
        purchaseRepo.deleteById(id);
    }

    @GetMapping("/deletePurchase/{id}")
    public String deletePurchase(@PathVariable (value = "id") long id){
        deletePurchaseById(id);
        return "redirect:/";
    }


    public TableController(PurchaseRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }
}
