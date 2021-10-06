package case_study.homework2.model;

import java.util.Date;

public class Receipt {
    String receiptID;
    Customer customer;
    Date receiptDate;
    int quantity;
    int unitPrice;

    public Receipt() {
    }

    public Receipt(String receiptID, Customer customer, Date receiptDate, int quantity, int unitPrice) {
        this.receiptID = receiptID;
        this.customer = customer;
        this.receiptDate = receiptDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }


    public double getSum() {
        if (customer instanceof CustomerVN) {
            int consume = ((CustomerVN) customer).getConsume();
            if (getQuantity() > consume) {
                return consume * getUnitPrice() + (getQuantity() - consume) * getUnitPrice() * 2.5;
            } else {
                return getQuantity() * getUnitPrice();
            }
        } else {
            return getQuantity() * getUnitPrice();
        }
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptID='" + receiptID + '\'' +
                ", customer=" + customer.getID() +
                ", receiptDate=" + receiptDate.getDate() + "/" + (receiptDate.getMonth() + 1) + "/" + (receiptDate.getYear() + 1900) +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", sum=" + getSum() +
                '}';
    }
    public String toStringDetail() {
        return "Receipt{" +
                "receiptID='" + receiptID + '\'' +
                ", customer=" + customer.getName() +
                ", receiptDate=" + receiptDate.getDate() + "/" + (receiptDate.getMonth() + 1) + "/" + (receiptDate.getYear() + 1900) +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", sum=" + getSum() +
                '}';
    }



    public String toStringToFile() {
        return receiptID +
                "," + customer.getID() +
                "," + receiptDate.getDate() + "/" + (receiptDate.getMonth() + 1) + "/" + (receiptDate.getYear() + 1900) +
                "," + quantity +
                "," + unitPrice +
                "," + getSum();
    }

}
