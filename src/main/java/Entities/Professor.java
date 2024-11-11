package Entities;

public class Professor {
    private String name;
    private String phone;
    private String imgSrc;
    private String dataNasc;
    private String cpf;
    private String street;
    private String street_number;
    private String city;
    private String state;

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
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getCpf() { return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public String getStreet_number() {return street_number;}
    public void setStreet_number(String street_number) {this.street_number = street_number;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}
}
