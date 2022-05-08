package com.ensao.pfa.pieceobjectmanager.repo;

import com.ensao.pfa.pieceobjectmanager.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail,Long> {
}
