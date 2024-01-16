package org.choongang.cs.controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InquirySave(
        @NotBlank
        String mode,
        String inquiryType,
        String title,
        String content
) {}
