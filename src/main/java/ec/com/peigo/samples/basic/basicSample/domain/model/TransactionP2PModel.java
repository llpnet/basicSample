package ec.com.peigo.samples.basic.basicSample.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@Builder
@Data
public class TransactionP2PModel {

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
