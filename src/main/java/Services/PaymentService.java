package Services;

import DAO.StudentDAOImpl;
import Entities.Payment;
import Entities.Student;
import DAO.PaymentDAOImpl;

import java.time.LocalDate;
import java.util.Date;

public class PaymentService {

    private PaymentDAOImpl paymentDAO;
    private StudentDAOImpl studentDAO;

    public PaymentService() {
        this.paymentDAO = new PaymentDAOImpl();
        this.studentDAO = new StudentDAOImpl();
    }

    public void registerNewStudent(Student student) {
        // Define a data de registro antes de salvar o estudante
        student.setRegistrationDate(java.sql.Date.valueOf(LocalDate.now()));

        // Salva o estudante no banco de dados e recupera o ID gerado
        studentDAO.save(student);

        // Criação do primeiro pagamento
        Payment initialPayment = new Payment();
        initialPayment.setPayerId(student.getId());
        initialPayment.setPayday(new Date()); // Inicializa com a data atual
        initialPayment.setExpirePayDay(java.sql.Date.valueOf(LocalDate.now().plusMonths(1)));
        initialPayment.setStatus("not_payed");
        initialPayment.setExpired(false);
        initialPayment.setAmount(15000); // Define um valor padrão, em centavos
        initialPayment.setPaymentMethod("default"); // Define um método de pagamento padrão
        initialPayment.setAccountId(1); // Define um ID de conta padrão
        initialPayment.setType_plan("standard"); // Define um plano padrão

        // Salva o primeiro pagamento no banco de dados
        paymentDAO.save(initialPayment);
    }
}
