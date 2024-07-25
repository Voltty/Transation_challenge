package picpay_challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import picpay_challenge.domain.Transfer;
import picpay_challenge.domain.User;
import picpay_challenge.repository.UserRepository;

import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public User debit(Transfer transfer) {
        User payer = transfer.getPayer();
        payer.setBalance(payer.getBalance().subtract(transfer.getValue()));
        return payer;
    }
    public User credit(Transfer transfer) {
        User payee = transfer.getPayee();
        payee.setBalance(payee.getBalance().add(transfer.getValue()));
        return payee;
    }
}
