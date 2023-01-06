package ec.com.peigo.samples.basic.basicSample.application.rest.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class TransactionP2PRestModel {

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
