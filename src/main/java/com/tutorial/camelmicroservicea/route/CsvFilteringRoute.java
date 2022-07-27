package com.tutorial.camelmicroservicea.route;

import com.tutorial.camelmicroservicea.model.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class CsvFilteringRoute extends RouteBuilder {
    @Override
    public void configure() {
        DataFormat dataFormat = new BindyCsvDataFormat(User.class);
        from("file:src/main/resources?fileName=userDB.csv&noop=true")
                .unmarshal(dataFormat)
                .process("filterUsernameProcessor")
                .bean("reverseUsername")
                .marshal(dataFormat)
                .log("${body}")
                .to("file:src/main/resources?fileName=filteredUserDB.csv&noop=true");
    }
}
