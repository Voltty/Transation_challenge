package picpay_challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import picpay_challenge.domain.Transfer;
import picpay_challenge.domain.User;
import picpay_challenge.exception.InsufficientBalanceException;
import picpay_challenge.exception.InvalidUserException;
import picpay_challenge.repository.TransferRepository;
import picpay_challenge.repository.UserRepository;

@Service
public class ServiceTransfer {

    @Autowired
    private ServiceUser serviceUser;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private UserRepository userRepository;

    public Transfer createTransfer(Transfer newTransfer) {
        validation(newTransfer);
        transferRepository.save(newTransfer);
        userRepository.save(serviceUser.credit(newTransfer));
        userRepository.save(serviceUser.debit(newTransfer));
        //authorize
        //notify
        return newTransfer;
    }

    public void validation(Transfer transfer) {
        User payer = transfer.getPayer();
        User payee = transfer.getPayee();
        if (payee == null || payer == null){
            throw new InvalidUserException("Invalid user",404);
        }
        if (payer.getSeller()){
            throw new InvalidUserException("Seller not allowed to pay",422);
        }
        if (payee.equals(payer)){
            throw new InvalidUserException("You are not allowed to transfer yourself",422);
        }
        if (payer.getBalance().compareTo(transfer.getValue()) >= 0) {
            throw new InsufficientBalanceException();
        }
    }
}
