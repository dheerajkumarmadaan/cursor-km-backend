package com.ttn.common.util;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.UUID;
import java.util.regex.Pattern;

@Component
public class Util {

    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Checks if a string is null or empty
     * @param str The string to check
     * @return true if the string is null or empty
     */
    public boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Checks if a collection is null or empty
     * @param collection The collection to check
     * @return true if the collection is null or empty
     */
    public boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Validates an email address format
     * @param email The email address to validate
     * @return true if the email is valid
     */
    public boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Generates a random UUID string
     * @return A UUID string
     */
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Formats a LocalDateTime object to string using default format
     * @param dateTime The LocalDateTime to format
     * @return Formatted date time string
     */
    public String formatDateTime(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(DEFAULT_DATETIME_FORMATTER) : null;
    }

    /**
     * Gets current timestamp in UTC
     * @return Current UTC timestamp
     */
    public LocalDateTime getCurrentUtcTime() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

    /**
     * Safely converts an object to string
     * @param obj The object to convert
     * @return String representation of the object or null
     */
    public String toSafeString(Object obj) {
        return obj != null ? obj.toString() : null;
    }

    /**
     * Safely parses a string to Integer
     * @param str The string to parse
     * @return The parsed Integer or null if parsing fails
     */
    public Integer parseInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Safely parses a string to Long
     * @param str The string to parse
     * @return The parsed Long or null if parsing fails
     */
    public Long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Safely parses a string to Double
     * @param str The string to parse
     * @return The parsed Double or null if parsing fails
     */
    public Double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean isEmptyString(String str) {
        return str == null || str.trim().isEmpty();
    }
} 