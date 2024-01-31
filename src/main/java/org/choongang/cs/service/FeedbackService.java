package org.choongang.cs.service;

import lombok.RequiredArgsConstructor;
import org.choongang.cs.controllers.RecordInquiry;
import org.choongang.cs.entities.FeedbackPost;
import org.choongang.cs.entities.Inquiry;
import org.choongang.cs.repositories.FeedbackPostRepository;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.service.FileInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedbackService {
    private final FeedbackPostRepository feedbackPostRepository;
    private final FileInfoService fileInfoService;

    public List<FeedbackPost> getAllList() {
        List<FeedbackPost> items = feedbackPostRepository.findAll();
        //items.forEach(this::addInfo);

        return items;
    }

    public FeedbackPost getOne(Long seq) {
        FeedbackPost feedbackPost = feedbackPostRepository.findById(seq).orElseThrow();
        addInfo(feedbackPost);
        return feedbackPost;
    }

    private void addInfo(FeedbackPost feedbackPost) {

        String gid = feedbackPost.getGid();
        List<FileInfo> items = fileInfoService.getListDone(gid);
        if (items != null && !items.isEmpty()) {
            feedbackPost.setImage(items.get(0));
        }
    }
}
