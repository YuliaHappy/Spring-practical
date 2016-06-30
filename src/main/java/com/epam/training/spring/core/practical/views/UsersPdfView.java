package com.epam.training.spring.core.practical.views;

import com.epam.training.spring.core.practical.basic.User;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class UsersPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        List<User> listUsers = (List<User>) map.get("listUsers");

        document.add(new Paragraph("Information about all users"));

        Table table = new Table(4, listUsers.size() + 1);
        table.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.blue);

        table.addCell(new Cell(new Phrase("Id", font)), new Point(0, 0));
        table.addCell(new Cell(new Phrase("Name", font)), new Point(0, 1));
        table.addCell(new Cell(new Phrase("Email", font)), new Point(0, 2));
        table.addCell(new Cell(new Phrase("Birthday", font)), new Point(0, 3));


        for (User user :
                listUsers) {
            table.addCell(Integer.toString(user.getId()));
            table.addCell(user.getName());
            table.addCell(user.getEmail());
            table.addCell(user.getBirthday().toString());

        }

        document.add(table);
    }
}
