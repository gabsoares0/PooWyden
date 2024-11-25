package Entities;
import java.util.Date;

public class Payment {
    private int id;
    private Date date;
    private double amount;
    private String type_plan;
    private int payerId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public float getAmount() {
        return (float) amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getType_plan() {
        return type_plan;
    }
    public void setType_plan(String type_plan) {
        this.type_plan = type_plan;
    }
    public int getPayerId() {
        return payerId;
    }
    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }
}
