package lk.ems.emsui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class EmsUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsUiApplication.class, args);
	}

}
