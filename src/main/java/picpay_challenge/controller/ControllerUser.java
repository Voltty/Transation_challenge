package picpay_challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import picpay_challenge.domain.Transfer;
import picpay_challenge.domain.User;
import picpay_challenge.repository.UserRepository;
import picpay_challenge.service.ServiceUser;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/User")
public class ControllerUser {
    
    @Autowired
    private ServiceUser serviceUser;


    @GetMapping("/Balance")
    public BigDecimal checkBalance(Long idUser) {
        return serviceUser.getUserById(idUser).getBalance();
    }

    @GetMapping("/User")
    public User getUserById(Long idUser) {
        return serviceUser.getUserById(idUser);
    }
    @GetMapping("/AllUsers")
    public List<User> getAllUsers() {
        return serviceUser.getAllUser();
    }
    @GetMapping("/Pay")
    public BigDecimal pay(Transfer transfer) {

        return null;
    }
    @GetMapping("/Rollback-Transaction")
    public void rollback(Long transactionId) {

    }


}
