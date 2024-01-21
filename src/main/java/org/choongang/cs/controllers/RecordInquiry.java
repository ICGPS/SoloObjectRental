package org.choongang.cs.controllers;

public record RecordInquiry(
        Long seq,
        String inquiryType,
        String title,
        String content,
        String createdAt
) {}
