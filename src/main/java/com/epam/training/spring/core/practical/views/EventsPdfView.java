package com.epam.training.spring.core.practical.views;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.epam.training.spring.core.practical.basic.Event;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;


public class EventsPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        List<Event> listEvents = (List<Event>) map.get("listEvents");

        document.add(new Paragraph("Information about all events"));

        Table table = new Table(5, listEvents.size() + 1);
        table.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.blue);

        table.addCell(new Cell(new Phrase("Name", font)), new Point(0, 0));
        table.addCell(new Cell(new Phrase("Date-time", font)), new Point(0, 1));
        table.addCell(new Cell(new Phrase("Rating", font)), new Point(0, 2));
        table.addCell(new Cell(new Phrase("Base price ticket", font)), new Point(0, 3));
        table.addCell(new Cell(new Phrase("Vip price ticket", font)), new Point(0, 4));


        for (Event event :
                listEvents) {
            table.addCell(event.getName());
            table.addCell(event.getDateTime().toString());
            table.addCell(event.getRating().toString());
            table.addCell(Integer.toString(event.getBasePriceTicket()));
            table.addCell(Integer.toString(event.getVipPriceTicket()));
        }

        document.add(table);
    }
}
