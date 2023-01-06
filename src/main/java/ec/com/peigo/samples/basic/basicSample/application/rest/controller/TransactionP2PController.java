package ec.com.peigo.samples.basic.basicSample.application.rest.controller;

import ec.com.peigo.samples.basic.basicSample.application.rest.mapper.TransactionP2PRestMapper;
import ec.com.peigo.samples.basic.basicSample.application.rest.model.TransactionP2PRestModel;
import ec.com.peigo.samples.basic.basicSample.domain.exception.DomainException;
import ec.com.peigo.samples.basic.basicSample.domain.mapper.TransactionP2PMapper;
import ec.com.peigo.samples.basic.basicSample.domain.model.TransactionP2PModel;
import ec.com.peigo.samples.basic.basicSample.domain.port.TransactionP2PServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class TransactionP2PController {

    private final TransactionP2PServicePort transactionP2PServicePort;

    @PostMapping("/createTransactionP2P")
    public Mono<TransactionP2PRestModel> createTransactionP2P(@RequestBody TransactionP2PRestModel transactionP2PRestModel) throws DomainException {

        return transactionP2PServicePort.createTransactionP2P(TransactionP2PRestMapper.INSTANCE.mapToTransactionP2PModel(transactionP2PRestModel))
                .flatMap(transactionP2PModel ->
                        Mono.just(TransactionP2PRestMapper.INSTANCE.mapToTransactionP2PRestModel(transactionP2PModel))
                );

    }

    @GetMapping("/getTransactionsP2PbyId/{id}")
    public Mono<TransactionP2PRestModel> getTransactionsP2PbyId(@PathVariable String id) throws DomainException {

        return transactionP2PServicePort.getTransactionsP2PbyId(id)
                .flatMap(transactionP2PModel ->
                        Mono.just(TransactionP2PRestMapper.INSTANCE.mapToTransactionP2PRestModel(transactionP2PModel))
                );
    }

    @GetMapping("/getTransactionsP2PbyAccount/{idAccount}")
    public Flux<TransactionP2PRestModel> getTransactionsP2PbyAccount(@PathVariable String idAccount) throws DomainException {

        return transactionP2PServicePort.getTransactionsP2PbyAccount(idAccount)
                .flatMap(transactionP2PModel ->
                        Mono.just(TransactionP2PRestMapper.INSTANCE.mapToTransactionP2PRestModel(transactionP2PModel))
                );
    }



}
