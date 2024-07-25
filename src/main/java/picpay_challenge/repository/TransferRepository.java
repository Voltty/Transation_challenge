package picpay_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import picpay_challenge.domain.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
