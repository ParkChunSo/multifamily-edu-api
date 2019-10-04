package com.cosmos.multifamily;

import com.cosmos.multifamily.domain.User;
import com.cosmos.multifamily.repository.UserRepository;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultifamilyApplicationTests {

    @Autowired
    private Gson gson;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        User user = userRepository.findUserByUserId("a");
        user.setResponse("1");
        System.out.println(gson.toJson(user));
    }

}
