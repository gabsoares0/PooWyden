package Entities;

import java.util.Date;

public class Payment {
    private int id;
    private Date payday;
    private double amount;
    private int payerId;
    private String paymentMethod;
    private int accountId;
    private String status; //Valores possíveis: "payed", "not_payed"
    private String type_plan;
    private Date expirePayDay;
    private boolean expired;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getPayDay() {
        return payday;
    }
    public void setPayday(Date payday) {
        this.payday = payday;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getPayerId() {
        return payerId;
    }
    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType_plan() { return type_plan; }
    public void setType_plan(String type_plan) { this.type_plan = type_plan; }

    public Date getExpirePayDay() { return expirePayDay; }
    public void setExpirePayDay(Date expirePayDay) { this.expirePayDay = expirePayDay; }

    public boolean isExpired() { return expired; }
    public void setExpired(boolean expired) { this.expired = expired; }
}
