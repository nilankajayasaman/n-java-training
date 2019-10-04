package lk.ems.emsui.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Components {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
