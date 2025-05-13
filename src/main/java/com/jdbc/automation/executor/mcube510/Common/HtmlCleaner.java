package com.jdbc.automation.executor.mcube510.Common;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class HtmlCleaner {
    public static String cleanHtml(String rawHtml) {
        // Decode HTML entities (e.g., &nbsp;) and remove tags
        Document doc = Jsoup.parse(rawHtml, "", Parser.xmlParser());
        return doc.text().replace("\u00A0", " ").trim();
    }
}

