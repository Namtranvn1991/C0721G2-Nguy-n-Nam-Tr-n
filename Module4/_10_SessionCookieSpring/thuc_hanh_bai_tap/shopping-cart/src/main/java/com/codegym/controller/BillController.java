package com.codegym.controller;

import com.codegym.model.Bill;
import com.codegym.model.BillDetail;
import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IBillDetailService;
import com.codegym.service.IBillService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BillController {
    @Autowired
    IBillDetailService iBillDetailService;

    @Autowired
    IProductService iProductService;

    @Autowired
    IBillService iBillService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/bills")
    public String showAllBills(){

        return "/billList";
    }

    @GetMapping("/check")
    public String checkCart(@SessionAttribute Cart cart, Model model){
        model.addAttribute("cart",cart);
        model.addAttribute("bill",new Bill());
        return "/check";
    }

    @PostMapping("/pay")
    public String pay(@SessionAttribute Cart cart,@ModelAttribute("bill") Bill bill){
        iBillService.save(bill);
        String name = bill.getCustomerName();
        for (Product product:cart.getProducts().keySet()) {
            BillDetail billDetail = new BillDetail();
            billDetail.setBill(iBillService.findPByName(name));
            billDetail.setProduct(product);
            billDetail.setQuantity(cart.getProducts().get(product));
            iBillDetailService.save(billDetail);
        }
        cart.getProducts().clear();
        return "/pay";
    }

    @GetMapping("/listBill")
    public String showListBill(Model model){
        List<BillDetail> billDetails = iBillDetailService.findAll();
        Map<Bill,Cart> billCartMap =new HashMap<>();
        for (BillDetail billDetail:billDetails) {
            if (!billCartMap.containsKey(billDetail.getBill())){
                Cart cart = new Cart();
                cart.addProduct(billDetail.getProduct());
                cart.setValue(billDetail.getProduct(),billDetail.getQuantity());
                billCartMap.put(billDetail.getBill(),cart);
            } else {
                billCartMap.get(billDetail.getBill()).addProduct(billDetail.getProduct());
                billCartMap.get(billDetail.getBill()).setValue(billDetail.getProduct(),billDetail.getQuantity());
            }
        }

        model.addAttribute("billCartMap",billCartMap);
        return "/billList";
    }
}
