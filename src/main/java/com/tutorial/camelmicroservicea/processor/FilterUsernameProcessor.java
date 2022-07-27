package com.tutorial.camelmicroservicea.processor;

import com.tutorial.camelmicroservicea.model.User;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterUsernameProcessor implements Processor {
    @Override
    public void process(Exchange exchange) {
        List<User> users = exchange.getIn().getBody(List.class);
        List<User> filtered = users.stream()
                .filter(user -> !user.getUsername().equals("Razmik"))
                .collect(Collectors.toList());
        exchange.getMessage().setBody(filtered);
    }
}
