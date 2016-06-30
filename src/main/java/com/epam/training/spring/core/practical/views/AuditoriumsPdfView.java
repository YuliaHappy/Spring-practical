package com.epam.training.spring.core.practical.views;

import com.epam.training.spring.core.practical.basic.Auditorium;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class AuditoriumsPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        List<Auditorium> listAuditoriums = (List<Auditorium>) map.get("listAuditoriums");

        document.add(new Paragraph("Information about all auditoriums"));

        Table table = new Table(3, listAuditoriums.size() + 1);
        table.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.blue);

        table.addCell(new Cell(new Phrase("Id", font)), new Point(0, 0));
        table.addCell(new Cell(new Phrase("Name", font)), new Point(0, 1));
        table.addCell(new Cell(new Phrase("Count of seats", font)), new Point(0, 2));


        for (Auditorium auditorium :
                listAuditoriums) {
            table.addCell(Integer.toString(auditorium.getId()));
            table.addCell(auditorium.getName());
            table.addCell(Integer.toString(auditorium.getCountOfSeats()));

        }

        document.add(table);
    }
}
