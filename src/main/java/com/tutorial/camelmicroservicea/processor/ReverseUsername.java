package com.tutorial.camelmicroservicea.processor;

import com.tutorial.camelmicroservicea.model.User;
import org.apache.camel.Body;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReverseUsername {
    public List<User> reverse(@Body List<User> users) {
        return users.stream()
                .peek(user -> {
                   String reversedUsername = reverseUsername(user.getUsername());
                   user.setUsername(reversedUsername);
                })
                .collect(Collectors.toList());
    }
    private String reverseUsername(String username){
        final StringBuilder builder = new StringBuilder(username);
        return builder.reverse().toString();
    }
}
