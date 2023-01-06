package ec.com.peigo.samples.basic.basicSample.infrastructure.adapter;

import ec.com.peigo.samples.basic.basicSample.domain.exception.DomainException;
import ec.com.peigo.samples.basic.basicSample.domain.exception.TransactionP2PException;
import ec.com.peigo.samples.basic.basicSample.infrastructure.entity.TransactionP2PEntity;
import ec.com.peigo.samples.basic.basicSample.infrastructure.port.TransactionP2PPersistencePort;
import ec.com.peigo.samples.basic.basicSample.infrastructure.repository.TransactionP2PReactiveRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.StringMatcher.CONTAINING;
import static org.springframework.data.domain.ExampleMatcher.StringMatcher.EXACT;

@AllArgsConstructor
@Component
public class TransactionP2PAdapter implements TransactionP2PPersistencePort {

    private final TransactionP2PReactiveRepository transactionP2PReactiveRepository;

    @Override
    public Mono<TransactionP2PEntity> createTransactionP2P(TransactionP2PEntity transactionP2PEntityMono) throws DomainException {

        return this.transactionP2PReactiveRepository.save(transactionP2PEntityMono);
    }


    @Override
    public Mono<TransactionP2PEntity> getTransactionsP2PbyId(String id) throws DomainException {
        Optional<Mono<TransactionP2PEntity>> existTransactionP2P = Optional.of(
                this.transactionP2PReactiveRepository.findById(id));
        return existTransactionP2P.orElseThrow(TransactionP2PException::new);

    }

    @Override
    public Flux<TransactionP2PEntity> getTransactionsP2PbyAccount(String idAccount) throws DomainException {

        /*TransactionP2PEntity transactionP2PEntity = TransactionP2PEntity.builder()
                .idAccountSender(idAccount)
                .idAccountReceive(idAccount)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("idAccountSender", ExampleMatcher.GenericPropertyMatcher.of(CONTAINING))
                .withMatcher("idAccountReceive", ExampleMatcher.GenericPropertyMatcher.of(CONTAINING));

        return this.transactionP2PReactiveRepository.findAll(Example.of(transactionP2PEntity,matcher));*/

        return this.transactionP2PReactiveRepository.findAllByIdAccountSenderOrIdAccountReceive(idAccount, idAccount);
    }

}
