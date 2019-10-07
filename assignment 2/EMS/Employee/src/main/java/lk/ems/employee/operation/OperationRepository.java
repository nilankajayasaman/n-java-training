package lk.ems.employee.operation;

import lk.ems.employee.entity.Employee;
import lk.ems.employee.entity.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {


    Page<Operation> findByEmployeeId(int employeeId, Pageable pageable);

    Page<Operation> findByEmployeeIdAndProjectId(int employeeId,int projectId, Pageable pageable);

}
