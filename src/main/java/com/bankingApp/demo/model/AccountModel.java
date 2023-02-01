package com.bankingApp.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "account_No")
    private String accountNo;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch")
    private String branch;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "balance_amount")
    private double balanceAmount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @OneToMany(mappedBy = "accountModel")
    private List<TransactionModel> transactionModelList;

    @OneToMany(mappedBy = "accountModel")
    private List<LoanModel> loanModelList;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<TransactionModel> getTransactionModelList() {
        return transactionModelList;
    }

    public void setTransactionModelList(List<TransactionModel> transactionModelList) {
        this.transactionModelList = transactionModelList;
    }

    public List<LoanModel> getLoanModelList() {
        return loanModelList;
    }

    public void setLoanModelList(List<LoanModel> loanModelList) {
        this.loanModelList = loanModelList;
    }
}
