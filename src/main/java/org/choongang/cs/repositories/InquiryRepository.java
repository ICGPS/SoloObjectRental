package org.choongang.cs.repositories;

import org.choongang.cs.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
