package lk.ems.employee.operation;

import lk.ems.employee.entity.Operation;
import lk.ems.employee.model.EmployeeHasProject;
import lk.ems.employee.model.EmployeeProjectHasTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {

    @Query("SELECT new lk.ems.employee.model.EmployeeHasProject(op,op.employee) FROM Operation op WHERE op.employeeId=:employeeId")
    Page<EmployeeHasProject> getOperationByEmployeeId(@Param("employeeId") int employeeId, Pageable pageable);

    @Query("SELECT new lk.ems.employee.model.EmployeeProjectHasTask(op,op.employee) FROM Operation op" +
            " WHERE op.employeeId=:employeeId AND op.projectId=:projectId")
    Page<EmployeeProjectHasTask> getEmployeeTasks(@Param("employeeId") int employeeId, @Param("projectId") int projectId, Pageable pageable);

}
