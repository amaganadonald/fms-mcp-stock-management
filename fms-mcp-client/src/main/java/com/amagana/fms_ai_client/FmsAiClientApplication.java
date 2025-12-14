package com.amagana.fms_ai_client;

import io.modelcontextprotocol.client.McpSyncClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
@SpringBootApplication
public class FmsAiClientApplication {

	private static final Logger log = LoggerFactory.getLogger(FmsAiClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FmsAiClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(List<McpSyncClient> clients) {
		return args -> clients.forEach(client -> client.listTools().tools().forEach(tool -> {
            log.info("-------------Information's tools available------");
            log.info("Information's about {}, description: {}, schema: {}" , tool.name(), tool.description(), tool.inputSchema());
        }));
	}

}
