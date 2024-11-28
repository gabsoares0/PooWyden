package Entities;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String phone;
    private String imgSrc;
    private String dataNasc;
    private Date registrationDate;
    private boolean allPaymentsUpToDate; //Indica se todos os pagamentos estão em dia

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgSrc() {
        return imgSrc;
    }
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isAllPaymentsUpToDate() { return allPaymentsUpToDate; }
    public void setAllPaymentsUpToDate(boolean allPaymentsUpToDate) { this.allPaymentsUpToDate = allPaymentsUpToDate; }

}
