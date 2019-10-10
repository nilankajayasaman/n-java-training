package lk.ems.emsui.conf;

import lk.ems.emsui.model.Employee;
import lk.ems.emsui.model.Operation;
import lk.ems.emsui.model.Project;
import lk.ems.emsui.model.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Components {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Employee employee(){return new Employee();}

    @Bean
    public Project project(){return new Project();}

    @Bean
    public Task task(){return new Task();}

    @Bean
    public Operation operation(){return new Operation();}

}
