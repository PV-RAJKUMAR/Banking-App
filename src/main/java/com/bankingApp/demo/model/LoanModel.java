package com.bankingApp.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class LoanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "status")
    private String status;
    @Column(name = "amt_requested")
    private double amt_req;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    private AccountModel accountModel;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmt_req() {
        return amt_req;
    }

    public void setAmt_req(double amt_req) {
        this.amt_req = amt_req;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }
}
