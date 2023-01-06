package ec.com.peigo.samples.basic.basicSample.infrastructure.port;

import ec.com.peigo.samples.basic.basicSample.domain.exception.DomainException;
import ec.com.peigo.samples.basic.basicSample.infrastructure.entity.TransactionP2PEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionP2PPersistencePort {

    Mono<TransactionP2PEntity> createTransactionP2P(TransactionP2PEntity transactionP2PEntityMono) throws DomainException;

    Mono<TransactionP2PEntity>  getTransactionsP2PbyId(String id) throws DomainException;

    Flux<TransactionP2PEntity> getTransactionsP2PbyAccount(String idAccount) throws DomainException;

}
