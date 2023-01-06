package ec.com.peigo.samples.basic.basicSample.domain.mapper;

import ec.com.peigo.samples.basic.basicSample.domain.model.TransactionP2PModel;
import ec.com.peigo.samples.basic.basicSample.infrastructure.entity.TransactionP2PEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper
public interface TransactionP2PMapper {

    TransactionP2PMapper INSTANCE = Mappers.getMapper(TransactionP2PMapper.class);

    TransactionP2PModel mapToTransactionP2PModel(TransactionP2PEntity transactionP2PEntity);
    List<TransactionP2PModel> mapToTransactionP2PModelFlux(List<TransactionP2PEntity> lstTransactionP2PEntityEntity);

    TransactionP2PEntity mapToTransactionP2PEntity(TransactionP2PModel transactionP2PModel);
    List<TransactionP2PEntity>  mapToTransactionP2PEntityList(List<TransactionP2PModel> transactionP2PModelFlux);

}
