package com.amagana.fms_ai_client.controllers;

import com.amagana.fms_ai_client.agents.AIAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIRestController {

    private final AIAgent aiAgent;

    public AIRestController(AIAgent aiAgent) {
        this.aiAgent = aiAgent;
    }


    @GetMapping("/chat")
    public String agentAsk(String query) {
        return aiAgent.askLLM(query);
    }
}
