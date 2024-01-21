package org.choongang.cs.repositories;

import org.choongang.cs.entities.FeedbackPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackPostRepository extends JpaRepository<FeedbackPost, Long> {

}
