package lk.ems.emsui.model;

import org.springframework.context.annotation.Scope;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Scope("prototype")
public class Employee {

    private Integer employeeId;


    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
