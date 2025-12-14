package com.amagana.fms_ai_server.mcp;

import com.amagana.fms_ai_server.mcp.adapters.CategoryMcpAdapter;
import com.amagana.fms_ai_server.mcp.adapters.ProductMcpAdapter;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpToolConfig {

    @Bean
    public MethodToolCallbackProvider methodToolCallbackProvider(ProductMcpAdapter productMcpAdapter
            , CategoryMcpAdapter categoryMcpAdapter) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(productMcpAdapter, categoryMcpAdapter)
                .build();
    }

}
