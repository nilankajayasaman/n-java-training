package lk.ems.employee.operation;

import com.commons.model.emsmodel.employee.Operation;
import com.commons.model.emsmodel.employee.OperationKey;
import lk.ems.employee.model.EmployeeHasProject;
import lk.ems.employee.model.EmployeeProjectHasTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OperationRepository extends JpaRepository<Operation, OperationKey> {
//
//    @Query(nativeQuery = true,value = "SELECT new lk.ems.employee.model.EmployeeHasProject(op) FROM Operation op WHERE op.employeeId= :employeeId")
//    Page<EmployeeHasProject> getOperationByEmployeeId(@Param("employeeId") int employeeId, Pageable pageable);
//
//
//    @Query(nativeQuery = true, value = "SELECT new lk.ems.employee.model.EmployeeProjectHasTask(op) FROM Operation op" +
//            " WHERE op.employeeId= :employeeId AND op.projectId= :projectId")
//    Page<EmployeeProjectHasTask> getEmployeeTasks(@Param("employeeId") int employeeId, @Param("projectId") int projectId, Pageable pageable);
//
////    @Query("SELECT op FROM Operation op WHERE op.employeeId=:employeeId")
////    Page<Operation> getOperationByEmployeeId(@Param("employeeId") int employeeId, Pageable pageable);
////
////    @Query("SELECT op FROM Operation op" +
////            " WHERE op.employeeId=:employeeId AND op.projectId=:projectId")
////    Page<Operation> getEmployeeTasks(@Param("employeeId") int employeeId, @Param("projectId") int projectId, Pageable pageable);

    @Query(value = "SELECT new lk.ems.employee.model.EmployeeHasProject(op) " +
            "FROM Operation op WHERE op.employeeId=:employeeId", nativeQuery = false,
            countQuery = "SELECT count(op) FROM Operation op")
    Page<EmployeeHasProject> getOperationByEmployeeId(@Param("employeeId") int employeeId, Pageable pageable);

    @Query(value = "SELECT new lk.ems.employee.model.EmployeeProjectHasTask(op) FROM Operation op" +
            " WHERE op.employeeId=:employeeId AND op.projectId=:projectId", nativeQuery = false,
            countQuery = "SELECT count(op) FROM Operation op")
    Page<EmployeeProjectHasTask> getEmployeeTasks(@Param("employeeId") int employeeId, @Param("projectId") int projectId, Pageable pageable);

//    @Query("SELECT op FROM Operation op WHERE op.employeeId=:employeeId")
//    Page<Operation> getOperationByEmployeeId(@Param("employeeId") int employeeId, Pageable pageable);
//
//    @Query("SELECT op FROM Operation op" +
//            " WHERE op.employeeId=:employeeId AND op.projectId=:projectId")
//    Page<Operation> getEmployeeTasks(@Param("employeeId") int employeeId, @Param("projectId") int projectId, Pageable pageable);
//

}
