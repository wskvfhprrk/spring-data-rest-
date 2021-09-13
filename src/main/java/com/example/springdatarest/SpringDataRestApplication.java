package com.example.springdatarest;

import com.example.springdatarest.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        List<User> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new User(100 + i, "he" + i, "he" + i + "@gg.com"));
        }
        userRepository.saveAll(list);
    }

}
