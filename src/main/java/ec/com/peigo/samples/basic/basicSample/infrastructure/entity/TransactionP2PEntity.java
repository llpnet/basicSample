package ec.com.peigo.samples.basic.basicSample.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@Document("transactions")
public class TransactionP2PEntity {

    @Id
    private String id;
    private Instant registerDate;
    private Instant confirmationDate;
    private String status;
    private Instant updateDate;
    private BigDecimal amount;
    private String token;
    private String channel;
    private String idAccountSender;
    private String idAccountReceive;

}
