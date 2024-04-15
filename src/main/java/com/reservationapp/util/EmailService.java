package com.reservationapp.util;

import com.reservationapp.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTicketEmail(String to, String subject, Passenger passenger) throws MessagingException {
        byte[] pdfBytes = PdfTicketGenerator.generateTicket(passenger);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText("Find attached your travel ticket.");

        ByteArrayResource pdfResource = new ByteArrayResource(pdfBytes);
        // Attachment
        helper.addAttachment("Ticket.pdf", pdfResource);

        mailSender.send(message);
    }
}

