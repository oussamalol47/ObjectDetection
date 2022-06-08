package com.ensao.pfa.pieceobjectmanager.service;


import com.ensao.pfa.pieceobjectmanager.model.Mail;
import com.ensao.pfa.pieceobjectmanager.repo.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    MailRepository repository;

    public Mail sendMail(Mail mail) throws MailException{
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("mohamed.benziza@ump.ac.ma");
        msg.setFrom("mohamed.benziza@ump.ac.ma");
        msg.setSubject(mail.getObjet());
        msg.setText(mail.getMessage());
        javaMailSender.send(msg);
        return repository.save(mail);
    }


}