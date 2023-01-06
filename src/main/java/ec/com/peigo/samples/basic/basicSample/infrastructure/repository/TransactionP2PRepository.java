package ec.com.peigo.samples.basic.basicSample.infrastructure.repository;

import ec.com.peigo.samples.basic.basicSample.infrastructure.entity.TransactionP2PEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionP2PRepository extends ReactiveCrudRepository<TransactionP2PEntity, String> {

    @Query("{ 'idAccountSender': ?0 }")
    List<TransactionP2PEntity> findAllByIdAccountSender(String idAccountSender);
}
