package DAO;

import Entities.Payment;

import java.util.List;

public interface PaymentDAO {
    void save(Payment payment);
    void update(Payment payment);
    void delete(int id);
    Payment FindById(int id);
    List<Payment> findAll();
}
