package lk.ems.employee.operation;

import lk.ems.employee.entity.Employee;
import lk.ems.employee.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl {

    @Autowired
    OperationRepository operationRepository;

    public Page<Operation> getAllOperation(int page){
        return operationRepository.findAll(PageRequest.of(page,10));
    }


    public Operation saveOperation(Operation operation){
        return operationRepository.save(operation);
    }


}
