package com.ttn.common.enums;

public enum ErrorCode {
    // Authentication & Authorization
    UNAUTHORIZED("Unauthorized access"),
    INVALID_CREDENTIALS("Invalid credentials"),
    TOKEN_EXPIRED("Token has expired"),
    INSUFFICIENT_PERMISSIONS("Insufficient permissions"),
    
    // Resource Operations
    RESOURCE_NOT_FOUND("Resource not found"),
    RESOURCE_ALREADY_EXISTS("Resource already exists"),
    CANNOT_MODIFY("Cannot modify resource"),
    CANNOT_DELETE("Cannot delete resource"),
    
    // Validation
    INVALID_INPUT("Invalid input provided"),
    MISSING_REQUIRED_FIELD("Required field is missing"),
    INVALID_FORMAT("Invalid format"),
    
    // Business Logic
    OPERATION_FAILED("Operation failed"),
    INVALID_STATE("Invalid state for operation"),
    BUSINESS_RULE_VIOLATION("Business rule violation"),
    
    // External Services
    EXTERNAL_SERVICE_ERROR("External service error"),
    COMMUNICATION_ERROR("Communication error"),
    TIMEOUT("Operation timed out"),
    
    // System
    INTERNAL_ERROR("Internal server error"),
    DATABASE_ERROR("Database error"),
    CONFIGURATION_ERROR("Configuration error");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
} 