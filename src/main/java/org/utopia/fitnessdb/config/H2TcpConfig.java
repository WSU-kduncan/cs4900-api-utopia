package org.utopia.fitnessdb.config;

import lombok.extern.log4j.Log4j2;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration
@Log4j2
@Profile("h2")
public class H2TcpConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        log.info("*** H2TcpConfig: H2 tcp access activated on port 9092 ***");
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
