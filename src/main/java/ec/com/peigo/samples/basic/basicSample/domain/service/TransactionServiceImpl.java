package ec.com.peigo.samples.basic.basicSample.domain.service;

import ec.com.peigo.samples.basic.basicSample.application.rest.mapper.TransactionP2PRestMapper;
import ec.com.peigo.samples.basic.basicSample.domain.exception.DomainException;
import ec.com.peigo.samples.basic.basicSample.domain.exception.TransactionP2PException;
import ec.com.peigo.samples.basic.basicSample.domain.mapper.TransactionP2PMapper;
import ec.com.peigo.samples.basic.basicSample.domain.model.TransactionP2PModel;
import ec.com.peigo.samples.basic.basicSample.domain.port.TransactionP2PServicePort;
import ec.com.peigo.samples.basic.basicSample.infrastructure.port.TransactionP2PPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@AllArgsConstructor
@Component
public class TransactionServiceImpl implements TransactionP2PServicePort {

    private final TransactionP2PPersistencePort transactionP2PPersistencePort;

    @Override
    public Mono<TransactionP2PModel> createTransactionP2P(TransactionP2PModel transactionP2PModel) throws DomainException {

        return this.transactionP2PPersistencePort.createTransactionP2P(TransactionP2PMapper.INSTANCE.mapToTransactionP2PEntity(transactionP2PModel))
                .flatMap(transactionP2PEntity ->
                        Mono.just(TransactionP2PMapper.INSTANCE.mapToTransactionP2PModel(transactionP2PEntity))
                );

    }

    @Override
    public Mono<TransactionP2PModel> getTransactionsP2PbyId(String id) throws DomainException {

        Optional<Mono<TransactionP2PModel>> existTransactionP2P = Optional.of(
                this.transactionP2PPersistencePort.getTransactionsP2PbyId(id)
                        .flatMap(transactionP2PEntity -> Mono.just(TransactionP2PMapper.INSTANCE.mapToTransactionP2PModel(transactionP2PEntity))));
        return existTransactionP2P.orElseThrow(TransactionP2PException::new);
    }

    @Override
    public Flux<TransactionP2PModel> getTransactionsP2PbyAccount(String idAccount) throws DomainException {
        Optional<Flux<TransactionP2PModel>> existTransactionP2P = Optional.of(
                this.transactionP2PPersistencePort.getTransactionsP2PbyAccount(idAccount)
                        .flatMap(transactionP2PEntity -> Mono.just(TransactionP2PMapper.INSTANCE.mapToTransactionP2PModel(transactionP2PEntity))));
        return existTransactionP2P.orElseThrow(TransactionP2PException::new);
    }

}
