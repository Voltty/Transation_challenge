package picpay_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import picpay_challenge.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
