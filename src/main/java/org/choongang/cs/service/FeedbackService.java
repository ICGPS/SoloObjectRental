package org.choongang.cs.service;

import lombok.RequiredArgsConstructor;
import org.choongang.cs.entities.FeedbackPost;
import org.choongang.cs.entities.Inquiry;
import org.choongang.cs.repositories.FeedbackPostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedbackService {
    private final FeedbackPostRepository feedbackPostRepository;

    public List<FeedbackPost> getAllList() {
        return feedbackPostRepository.findAll();
    }
}
