package com.jdbc.automation.executor.mcube4520.com.mcube.qa.sanity.pdf.creator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.jdbc.automation.executor.Common.Records;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class PdfCreator {
    private static final Logger log= LoggerFactory.getLogger(PdfCreator.class);

    public static void main(String[] arr){
        List<Records> lr=new ArrayList<>() ;
        createSanityReportPdf(lr,"abcd","a","b","c","d");
    }

    public static File createSanityReportPdf(List<Records> listResults,String url,String createdBy,String createdByName,String client,String version){
        File file=null;
        Document document =null;
        System.out.println("[SANITY][PDF CREATOR] Creating pdf.......");
        try{
            String folderPath="reports"+File.separator+ Calendar.getInstance().getTimeInMillis()+File.separator;
            System.out.println("[SANITY][PDF CREATOR] Report folder path: "+folderPath);
            (new File(folderPath)).mkdirs();
            document = new Document();
            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(folderPath+"Sanity Report.pdf"));
//            PdfHeader event = new PdfHeader();
//            writer.setPageEvent(event);
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

            Image img = Image.getInstance("logo.png");
            img.scalePercent(60);
            img.setAlignment(Element.ALIGN_LEFT);
//            img.setAbsolutePosition(467,750);
            document.add(img);
            Paragraph chunk = new Paragraph("Sanity Report for "+client+" "+ version, font);

            document.add(chunk);

            Paragraph chunk3 = new Paragraph("URL:"+url, font);

            document.add(chunk3);

            if(!createdByName.equalsIgnoreCase("NA")){
                Paragraph chunk1 = new Paragraph("Executed By:"+createdByName, font);

                document.add(chunk1);
            }
            if(!createdBy.equalsIgnoreCase("NA")){
                Paragraph chunk1 = new Paragraph("Email:"+createdBy, font);

                document.add(chunk1);
            }

            Paragraph chunk1 = new Paragraph("Generated At:"+Calendar.getInstance(TimeZone.getTimeZone("IST")).getTime(), font);

            document.add(chunk1);

            Paragraph chunk2 = new Paragraph(" ");
            document.add(chunk2);

            PdfPTable table = new PdfPTable(new float[] { 4, 23, 23, 45, 10});
            table.setWidthPercentage(100);
            addTableHeader(table);

            PdfPTable screenShotsTable = new PdfPTable(1);
            screenShotsTable.setWidthPercentage(100);
            addScreenShotTableHeaader(screenShotsTable); //Doubt - It's use in pdf

            AtomicInteger i= new AtomicInteger(1);
            listResults.forEach(e->{
                try {
                    addCustomRows(table,e, i.get());
//                    addScreenShotRows(screenShotsTable,e);
                } catch (Exception ex) {
                    log.error("",ex);
                }

                i.getAndIncrement();
            });


            document.add(table);
            document.newPage();
            Font titleFont = FontFactory.getFont(FontFactory.COURIER, 15, BaseColor.BLACK);

            Paragraph titleHeader=new Paragraph();
            Chunk c = new Chunk("Screenshots",titleFont);
//            c.setBackground(new BaseColor(51,102,204));
            titleHeader.add(c);
            document.add(titleHeader);
            Document finalDocument = document;
            listResults.forEach(e-> {
                try {
                    addScreenShotPages(finalDocument,e);
                } catch (Exception ex) {
                    log.error("",ex);
                }
            });
            document=finalDocument;
//            document.add(screenShotsTable);

            file=new File(folderPath+"Sanity Report.pdf");
        }catch (Exception e){
            log.error("",e);
        }finally {
            if(null!=document){
                document.close();
            }
        }
        System.out.println("[SANITY][PDF CREATOR] Finished creating pdf.......");
        return file;
    }

    private static void addScreenShotPages(Document finalDocument, Records record) throws Exception {



        Font font = FontFactory.getFont(FontFactory.COURIER, 9, BaseColor.BLACK);

        Paragraph indexCell = new Paragraph(record.getTestCaseName(), font);

        finalDocument.add(indexCell);
        AtomicInteger i= new AtomicInteger(1);
        record.getScreenShot().forEach(e->{
            Image img = null;
            try {
                Paragraph chunk1 = new Paragraph(i.get()+"", font);
                finalDocument.add(chunk1);

                img = Image.getInstance(e.getAbsolutePath());
                img.scalePercent(35);
                img.setAlignment(Element.ALIGN_CENTER);

                finalDocument.add(img);
                i.getAndIncrement();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        finalDocument.newPage();
    }


    private static void addScreenShotTableHeaader(PdfPTable table){  //Doubt - It's use in pdf
        PdfPCell titleHeader = new PdfPCell();
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        titleHeader.setBackgroundColor(new BaseColor(51,102,204));
        titleHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleHeader.setVerticalAlignment(Element.ALIGN_CENTER);
        titleHeader.setBorderWidth(1);
        titleHeader.setPhrase(new Phrase("Screenshots",font));
        table.addCell(titleHeader);
    }
    private static void addTableHeader(PdfPTable table) {
        PdfPCell titleHeader = new PdfPCell();
        Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
        titleHeader.setBackgroundColor(new BaseColor(51,102,204));
        titleHeader.setBorderWidth(1);
        titleHeader.setPhrase(new Phrase("Results",font));
        titleHeader.setColspan(5);
        table.addCell(titleHeader);
        Stream.of("#", "Test Case ID", "Description", "Expected Outcome", "Result")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    header.setBackgroundColor(new BaseColor(51,102,204));
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle,font));
                    table.addCell(header);
                });
    }

    private static void addCustomRows(PdfPTable table, Records record, int index) throws Exception {

        Font font = FontFactory.getFont(FontFactory.COURIER, 9, BaseColor.BLACK);
        PdfPCell indexCell = new PdfPCell(new Phrase(""+index,font));
        indexCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(indexCell);

        PdfPCell tcCell = new PdfPCell(new Phrase(record.getTestCaseName(),font));
        tcCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(tcCell);

        PdfPCell descCell = new PdfPCell(new Phrase(record.getName(),font));
        descCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(descCell);

        PdfPCell eoCell = new PdfPCell(new Phrase(record.getExpectedResult(),font));
        eoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(eoCell);

        PdfPCell resultCell = new PdfPCell();
        if(record.isOutcome()){
            Font successFont = FontFactory.getFont(FontFactory.COURIER, 9, BaseColor.GREEN);
            Chunk chunk = new Chunk("PASS", successFont);
            resultCell.addElement(chunk);
        }else{
            Font errorFont = FontFactory.getFont(FontFactory.COURIER, 9, BaseColor.RED);
            Chunk chunk = new Chunk("FAIL", errorFont);
            resultCell.addElement(chunk);
        }

        resultCell.setHorizontalAlignment(Element.ALIGN_LEFT);

//        Anchor linking_point = new Anchor("Click to go screenshot");
//        linking_point.setReference("#"+record.getTestCaseName());
//        document.add(linking_point);

//        resultCell.s

//        PdfAction action = new PdfAction("#"+record.getTestCaseName());
//        chunk.setAction(action);

        table.addCell(resultCell);
    }

    private static void addScreenShotRows(PdfPTable table, Records record) throws Exception {
        Font font = FontFactory.getFont(FontFactory.COURIER, 9, BaseColor.BLACK);

        PdfPCell indexCell = new PdfPCell();
        Chunk chunk = new Chunk(record.getTestCaseName(), font);
//        chunk.setAnchor(record.getTestCaseName());
        indexCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        indexCell.addElement(chunk);
//        Anchor source_point = new Anchor("");
//        source_point.setName(record.getTestCaseName());
//        document.add(source_point);
        table.addCell(indexCell);
        AtomicInteger i= new AtomicInteger(1);
        record.getScreenShot().forEach(e->{
            Image img = null;
            try {
                Paragraph chunk1 = new Paragraph(i.get()+"", font);
                PdfPCell hashCell = new PdfPCell();
                hashCell.setBackgroundColor(new BaseColor(51,102,204));
                hashCell.addElement(chunk1);
                table.addCell(hashCell);
                //        chunk.setAnchor(record.getTestCaseName());
                indexCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                indexCell.addElement(chunk1);
                img = Image.getInstance(e.getAbsolutePath());
                img.scalePercent(30);
                img.setAlignment(Element.ALIGN_CENTER);
                PdfPCell imageCell = new PdfPCell(img,Boolean.TRUE);
                imageCell.setBackgroundColor(BaseColor.WHITE);
                table.addCell(imageCell);
                i.getAndIncrement();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
    }

    public static class PdfHeader extends PdfPageEventHelper {

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            try {
                Rectangle pageSize = document.getPageSize();
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("Sanity Report"), pageSize.getLeft(0), pageSize.getTop(30), 0);
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(String.format("%s", writer.getCurrentPageNumber())),
                        pageSize.getRight(30), pageSize.getTop(30), 0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
