package lk.codelabs.smsui.conf;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

public class AccessTokenConfigure {

    public static String getToken(){

        OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getDetails();

        return authenticationDetails.getTokenValue();
    }

}
