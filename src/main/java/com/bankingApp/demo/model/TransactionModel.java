package com.bankingApp.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trsc_id")
    private int trscId;
    @Column(name = "user_Id")
    private int userId;
    @Column(name = "withdraw_amount")
    private double wdrAmt;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
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

    public double getWdrAmt() {
        return wdrAmt;
    }

    public void setWdrAmt(double wdrAmt) {
        this.wdrAmt = wdrAmt;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }
}
