package ec.com.peigo.samples.basic.basicSample.infrastructure.repository;

import ec.com.peigo.samples.basic.basicSample.infrastructure.entity.TransactionP2PEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface TransactionP2PReactiveRepository extends ReactiveMongoRepository<TransactionP2PEntity, String> {

    Flux<TransactionP2PEntity> findAllByIdAccountSenderOrIdAccountReceive(String idAccountSender, String idAccountReceive);
}
