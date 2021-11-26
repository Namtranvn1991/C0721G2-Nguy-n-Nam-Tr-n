package com.codegym.model;

import javax.persistence.*;

@Entity
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBillDetail;

    private Integer quantity;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(targetEntity = Bill.class)
    @JoinColumn(name = "billId")
    private Bill bill;

    public BillDetail() {
    }

    public Integer getIdBillDetail() {
        return idBillDetail;
    }

    public void setIdBillDetail(Integer idBillDetail) {
        this.idBillDetail = idBillDetail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
