package com.example.projecttracker.util.annotation;

import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This is an annotation that validates the severity of an issue.
 *
 * @author Alyssa Heimlicher
 * @version 1.2
 * @since 2022-06-20
 */
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IssueSeverityValidator.class})
public @interface IssueSeverity {
    String message() default "Invalid Severity! Severity must be one of the following: Critical, Major, Minor, Trivial";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}