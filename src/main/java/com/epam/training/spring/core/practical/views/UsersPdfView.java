package com.epam.training.spring.core.practical.views;

import com.epam.training.spring.core.practical.basic.User;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        document.add(new Paragraph("Информация обо всех пользователях"));

        Table table = new Table(4, listUsers.size());
        table.setPadding(5);
        table.addCell(new Cell("Id"),0 ,0);
        table.addCell(new Cell("Имя"),0 ,1);
        table.addCell(new Cell("Электронная почта"),0 ,2);
        table.addCell(new Cell("Дата рождения"),0 ,3);

        for (User user :
                listUsers) {
            table.addCell(Integer.toString(user.getId()));
            table.addCell(user.getName());
            table.addCell(user.getEmail());
            table.addCell(user.getBirthday().toString());

        }


//        PdfTable table = new PdfTable();


//        PdfPTable table = new PdfPTable(5);
//        table.setWidthPercentage(100.0f);
//        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
//        table.setSpacingBefore(10);

        // define font for table header row
//        Font font = FontFactory.getFont(FontFactory.HELVETICA);
//        font.setColor(BaseColor.WHITE);
//
//        // define table header cell
//        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(BaseColor.BLUE);
//        cell.setPadding(5);
//
//        // write table header
//        cell.setPhrase(new Phrase("Book Title", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Author", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("ISBN", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Published Date", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Price", font));
//        table.addCell(cell);

        // write table row data
//        for (Book aBook : listBooks) {
//            table.addCell(aBook.getTitle());
//            table.addCell(aBook.getAuthor());
//            table.addCell(aBook.getIsbn());
//            table.addCell(aBook.getPublishedDate());
//            table.addCell(String.valueOf(aBook.getPrice()));
//        }

        document.add(table);
    }
}
