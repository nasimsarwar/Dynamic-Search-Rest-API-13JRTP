package com.ashokit.export;
import java.util.*;
import com.ashokit.dto.IncuranceDTO;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;



public class IncurancePDFExport {
	private List<IncuranceDTO> incDto;
    
    public IncurancePDFExport(List<IncuranceDTO> incDto) {
        this.incDto = incDto;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Plan_Id", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Plan_Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Holder_Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Holder_SSN", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("plan_Status", font));
        table.addCell(cell);       
    }
    
    private void writeTableData(PdfPTable table) {
        for (IncuranceDTO incurancedto : incDto) {
            table.addCell(String.valueOf(incurancedto.getPlanId()));
            table.addCell(incurancedto.getHolderName());
            table.addCell(incurancedto.getPlanName());
            table.addCell(String.valueOf(incurancedto.getHolderSSN()));
            table.addCell(incurancedto.getPlanStatus());
        }
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Incurance Clints Information", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
    
    
    
}
