package com.example.demo.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration
@Profile("!test") // Exclude this configuration in the 'test' profile
public class H2ConsoleConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2WebConsoleServer() throws SQLException {
        // Change port to 8082 or 80
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082", "-tcpAllowOthers", "-tcpServerDaemon");
    }
}

