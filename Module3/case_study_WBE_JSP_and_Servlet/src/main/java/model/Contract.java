package model;

import java.util.Date;

public class Contract {
    private int id_contract;
    Customer customer;
    Employee employee;
    Service service;
    Date contract_date;
    Date end_date;
    double deposit;

    public Contract() {
    }

    public Contract(int id_contract, Customer customer, Employee employee, Service service, Date contract_date, Date end_date, double deposit) {
        this.id_contract = id_contract;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
        this.contract_date = contract_date;
        this.end_date = end_date;
        this.deposit = deposit;
    }

    public Contract(Customer customer, Employee employee, Service service, Date contract_date, Date end_date, double deposit) {
        this.customer = customer;
        this.employee = employee;
        this.service = service;
        this.contract_date = contract_date;
        this.end_date = end_date;
        this.deposit = deposit;
    }

    public int getId_contract() {
        return id_contract;
    }

    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getContract_date() {
        return contract_date;
    }

    public void setContract_date(Date contract_date) {
        this.contract_date = contract_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id_contract=" + id_contract +
                ", customer=" + customer +
                ", employee=" + employee +
                ", service=" + service +
                ", contract_date=" + contract_date +
                ", end_date=" + end_date +
                ", deposit=" + deposit +
                '}';
    }
}
