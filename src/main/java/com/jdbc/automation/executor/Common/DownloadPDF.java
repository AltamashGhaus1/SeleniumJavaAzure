package com.jdbc.automation.executor.Common;

import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DownloadPDF {
    public static Boolean download_PDF(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws InterruptedException {

        Boolean flag = false;
        String expected_text_PDF ="ID";

        List<File> screenShot = new ArrayList<>();
        Records record = new Records();
        Boolean actualOutcome = false;

        try {

            /**File file = new File(pdfPath);
             PDDocument document = PDDocument.load(file);
             PDFTextStripper pdfStripper = new PDFTextStripper();
             String text = pdfStripper.getText(document);

             // Validate specific content in the PDF
             assert text.contains(expected_text_PDF);
             document.close();**/


            // Set the download directory
            String downloadFilePath = "C:\\Users\\Aafrin.Parween\\Downloads";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-popup-blocking");

            // Set preferences for automatic download
            options.addArguments("download.default_directory=" + downloadFilePath);
            options.addArguments("plugins.always_open_pdf_externally=true"); // Prevents Chrome from opening PDFs in-browser

            driver.findElement(By.xpath("(//button[@class=\"mantine-UnstyledButton-root mantine-ActionIcon-root mantine-1t9ka5r\"])[3]")).click();
            Thread.sleep(10000);

            File downloadedFile = new File(downloadFilePath + "/testComponent.pdf");

            if (downloadedFile.exists()) {
                System.out.println("PDF file downloaded successfully!");
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
            } else {
                System.out.println("PDF file not found!");
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
            }

        }

        catch (Exception e) {
            e.toString();
            e.getMessage();
            System.out.println("Download PDF Error : "+e);
            flag = false;
            return flag;
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-PDF-01");
            record.setOutcome(actualOutcome);
            record.setName("PDF DOWNLOAD");
            record.setScreenShot(screenShot);
            record.setExpectedResult("PDF DOWNLOADED SUCCESSFULLY");
            clientVersionDao.setRecordDetails(record);
            listOb.add(record);
        }
        return flag;

    }
}
