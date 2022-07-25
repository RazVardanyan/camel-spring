package com.tutorial.camelmicroservicea.route;

import com.tutorial.camelmicroservicea.model.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CsvRoute extends RouteBuilder {
    private final Logger LOGGER = LoggerFactory.getLogger(CsvRoute.class);

    @Override
    public void configure(){
        from("file:src/main/resources?fileName=userDB.csv&noop=true")
                .unmarshal(new BindyCsvDataFormat(User.class))
                .process(exchange -> {
                    List<User> users = exchange.getIn().getBody(List.class);
                    users.forEach(user -> LOGGER.info("This is each user data: {}", user));
                });
    }
}
