package com.amagana.fms_ai_server.mcp;

import org.springframework.ai.tool.execution.ToolCallResultConverter;

import java.lang.reflect.Type;

public class IdentityToolCallResultConverter implements ToolCallResultConverter {

    @Override
    public String convert(Object result, Type returnType) {
        return result.toString();
    }
}

