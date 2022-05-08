package com.ensao.pfa.pieceobjectmanager.resource;

import com.ensao.pfa.pieceobjectmanager.model.Mail;
import com.ensao.pfa.pieceobjectmanager.model.Piece;
import com.ensao.pfa.pieceobjectmanager.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/mail")
public class MailResource {

    @Autowired
    private SendMailService sendMailService;

    @PostMapping(value = "/add",consumes="application/json")
    public ResponseEntity<Mail> addMail(@RequestBody Mail mail){
        Mail newMail = sendMailService.sendMail(mail);
        return new ResponseEntity<>(newMail, HttpStatus.CREATED);
    }


}
