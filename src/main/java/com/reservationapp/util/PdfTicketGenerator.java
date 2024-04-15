package com.reservationapp.util;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.reservationapp.entity.Passenger;

import java.io.ByteArrayOutputStream;

public class PdfTicketGenerator {

    public static byte[] generateTicket(Passenger passenger) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Ticket Confirmation"));
        document.add(new Paragraph("Name: " + passenger.getFirstName() + " " + passenger.getLastName()));
        document.add(new Paragraph("Email: " + passenger.getEmail()));
        document.add(new Paragraph("Mobile: " + passenger.getMobile()));
        document.add(new Paragraph("From: " + passenger.getFromLocation() + " To: " + passenger.getToLocation()));
        document.add(new Paragraph("Bus ID: " + passenger.getBusId()));
        document.add(new Paragraph("Route ID: " + passenger.getRouteId()));
        document.add(new Paragraph("Sub Route ID: " + passenger.getSubRouteId()));

        document.close();

        return baos.toByteArray();
    }
}

