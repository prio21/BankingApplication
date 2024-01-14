package com.sapient.BankApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaction_history")
public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @ManyToOne
    @JoinColumn(name = "customer_aadhar")
    @JsonIgnore
    private Customer cus;

//    private int years;
//    private String loan_type;
    
    private String Transaction_type;
    private float amount;

    public Transactions(String transaction_type, float amount, Customer cus) {
       super();
        Transaction_type = transaction_type;
        this.amount = amount;
        this.cus = cus;
       
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

  

    public Transactions() {

    }

    public String getTransaction_type() {
        return Transaction_type;
    }

    public void setTransaction_type(String Transaction_type) {
        this.Transaction_type = Transaction_type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
