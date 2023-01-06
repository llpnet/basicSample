package ec.com.peigo.samples.basic.basicSample.application.rest.mapper;

import ec.com.peigo.samples.basic.basicSample.application.rest.model.TransactionP2PRestModel;
import ec.com.peigo.samples.basic.basicSample.domain.mapper.TransactionP2PMapper;
import ec.com.peigo.samples.basic.basicSample.domain.model.TransactionP2PModel;
import ec.com.peigo.samples.basic.basicSample.infrastructure.entity.TransactionP2PEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper
public interface TransactionP2PRestMapper {

    TransactionP2PRestMapper INSTANCE = Mappers.getMapper(TransactionP2PRestMapper.class);

    TransactionP2PRestModel mapToTransactionP2PRestModel(TransactionP2PModel transactionP2PModel);
    List<TransactionP2PRestModel> mapToTransactionP2PRestModelFlux(List<TransactionP2PModel> transactionP2PModelList);

    TransactionP2PModel mapToTransactionP2PModel(TransactionP2PRestModel transactionP2PRestModel);
    List<TransactionP2PModel>  mapToTransactionP2PModelList(List<TransactionP2PRestModel> transactionP2PRestModelList);

}
