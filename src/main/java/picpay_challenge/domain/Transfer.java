package picpay_challenge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
    @ManyToOne
    private User Payer;
    @ManyToOne
    private User Payee;
    private BigDecimal value;
    private LocalDateTime createdAt;
}
