package com.codegym.model;

import java.util.Map;

public class CustomerBill {
    Bill bill;
    Cart cart;

    public CustomerBill() {
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
