package com.cosmos.multifamily.security;

import com.cosmos.multifamily.config.UserAdapter;
import com.cosmos.multifamily.domain.User;
import com.cosmos.multifamily.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(AuthSuccessHandler.class);
    private final UserRepository userRepository;
    private Gson gson;

    public AuthSuccessHandler(UserRepository userRepository, Gson gson) {
        this.userRepository = userRepository;
        this.gson = gson;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson customGson = gsonBuilder.registerTypeAdapter(User.class, new UserAdapter()).create();
        response.setStatus(HttpServletResponse.SC_OK);
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        User user = userRepository.findUserByUserId(userDetails.getUsername());
        user.setResponse("1");
        response.getWriter().print(customGson.toJson(user));
        response.getWriter().flush();
    }
}
