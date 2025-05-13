package com.jdbc.automation.executor.mcube510.com.mcube.qa.sanity.email;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;

import java.io.IOException;

public class PDFPageExtractor {

    public static void main(String[] args) {
        // Input and output file paths
        String sourcePdfPath = "path/to/source.pdf"; // Path to the large PDF
        String targetPdfPath = "path/to/output.pdf"; // Path for the output PDF

        try {
            // Open the source PDF document
            PdfDocument sourcePdf = new PdfDocument(new PdfReader(sourcePdfPath));

            // Create the target PDF document
            PdfDocument targetPdf = new PdfDocument(new PdfWriter(targetPdfPath));

            // PdfMerger to add specific pages
            PdfMerger merger = new PdfMerger(targetPdf);

            // Extract specific pages (e.g., pages 1 and 2)
            merger.merge(sourcePdf, 1, 1); // Extract page 1
            merger.merge(sourcePdf, 2, 2); // Extract page 2

            // Close both documents
            sourcePdf.close();
            targetPdf.close();

            System.out.println("PDF created successfully: " + targetPdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
