package lk.codelabs.OAuthServer.OAuthServer.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class controller {

    @RequestMapping("/expire")
    public void exit(HttpServletRequest request, HttpServletResponse response, Authentication authentication){

        new SecurityContextLogoutHandler().logout(request, null, authentication);
        try {
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
