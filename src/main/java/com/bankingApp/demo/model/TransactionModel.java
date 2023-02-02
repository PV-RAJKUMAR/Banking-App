package com.bankingApp.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trsc_id")
    private int trscId;
    @Column(name = "user_Id")
    private int userId;

    @Column(name = "transaction_amount")
    private double transactAmt;

    @Column(name = "transaction_date")
    private Date transactDate;

    @Column(name = "mode")
    private String mode;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private AccountModel accountModel;

    public int getTrscId() {
        return trscId;
    }

    public void setTrscId(int trscId) {
        this.trscId = trscId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTransactAmt() {
        return transactAmt;
    }

    public void setTransactAmt(double transactAmt) {
        this.transactAmt = transactAmt;
    }

    public Date getTransactDate() {
        return transactDate;
    }

    public void setTransactDate(Date transactDate) {
        this.transactDate = transactDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }
}
