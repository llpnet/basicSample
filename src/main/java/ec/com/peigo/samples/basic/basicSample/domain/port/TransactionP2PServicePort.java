package ec.com.peigo.samples.basic.basicSample.domain.port;

import ec.com.peigo.samples.basic.basicSample.domain.exception.DomainException;
import ec.com.peigo.samples.basic.basicSample.domain.model.TransactionP2PModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TransactionP2PServicePort {

    Mono<TransactionP2PModel> createTransactionP2P(TransactionP2PModel transactionP2PModel) throws DomainException;

    Mono<TransactionP2PModel> getTransactionsP2PbyId(String id) throws DomainException;

    Flux<TransactionP2PModel> getTransactionsP2PbyAccount(String idAccount) throws DomainException;

}
