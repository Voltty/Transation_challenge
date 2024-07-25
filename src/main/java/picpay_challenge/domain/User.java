package picpay_challenge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String completeName;
    @Column(unique = true)
    private String CPF;
    @Column(unique = true)
    private String email;
    private String password;
    private Boolean Seller;
    private BigDecimal balance;

}
