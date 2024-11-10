package com.jdbc.automation.executor.cigna.com.mcube.qa.sanity.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmailSender {
    private static final Logger log= LoggerFactory.getLogger(EmailSender.class);
    private static int counter = 0;

    /*  public static void main(String args[])
      {
          try {
              List<File> fileList = new ArrayList<>();
              sendEmail("altamash.ghaus@tcgdigital.com","","","abcde","AB_ABCD",fileList);
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }*/
    public static void sendEmail(String to, String cc, String bcc, String body,
                                 String subject, List<File> attachments) throws Exception {
        try {
            System.out.println("to--->" + to);
            System.out.println("cc--->" + cc);
            System.out.println("bcc--->" + bcc);
            System.out.println("body--->" + body);
            System.out.println("subject--->" + subject);

            Properties props = new Properties();
            props.put("mail.smtp.host", System.getenv("SMTP_HOST"));
            props.put("mail.smtp.socketFactory.port",System.getenv("SMTP_PORT"));
            props.put("mail.smtp.port", System.getenv("SMTP_PORT"));

            boolean canAuthenticate = true;
            if (System.getenv("SMTP_USER") == null) {
                canAuthenticate = false;
            } else if (System.getenv("SMTP_USER").equalsIgnoreCase("")) {
                canAuthenticate = false;
            }
            if (System.getenv("SMTP_PASSWORD") == null) {
                canAuthenticate = false;
            } else if (System.getenv("SMTP_PASSWORD").equalsIgnoreCase("")) {
                canAuthenticate = false;
            }
            Session session = null;
            if (canAuthenticate) {
                System.out.println("Sending mail with authentication.....");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                session = Session.getInstance(props,
                        new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(
                                        System.getenv("SMTP_USER"),
                                        System.getenv("SMTP_PASSWORD"));
                            }
                        });
            } else {
                System.out.println("Sending mail without authentication.....");
                session = Session.getInstance(props);
            }
            Message message = new MimeMessage(session);
            boolean isFrom=true;
            if (System.getenv("SMTP_SENDER") == null) {
                isFrom = false;
            } else if (System.getenv("SMTP_SENDER").equalsIgnoreCase("")) {
                isFrom = false;
            }
            if(isFrom){
                System.out.println("Sending mail with sender name.....");
                message.setFrom(new InternetAddress(
                        System.getenv("SMTP_SENDER")));
            }else{
                System.out.println("Sending mail without sender name.....");
                message.setFrom(new InternetAddress(
                        System.getenv("SMTP_USER")));
            }

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(cc));
            message.setRecipients(Message.RecipientType.BCC,
                    InternetAddress.parse(bcc));
            message.setSubject(subject);

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setContent(body, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            if (null != attachments) {
                System.out.println("adding attachment...");
                if (!attachments.isEmpty()) {
                    for (int i = 0; i < attachments.size(); i++) {
                        MimeBodyPart messageBodyPart2 = new MimeBodyPart();

                        DataSource source = new FileDataSource(
                                attachments.get(i));
                        messageBodyPart2
                                .setDataHandler(new DataHandler(source));
                        messageBodyPart2.setFileName(attachments.get(i)
                                .getName());
                        multipart.addBodyPart(messageBodyPart2);
                    }
                    System.out.println("attachment added");
                }
            }
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Mail Sent Successfully for sanity");

        }catch (Exception e) {
            log.error("", e);
            counter++;
            if (counter < 3) {
                sendEmail(to, cc, bcc, body, subject, attachments);
            } else {
                throw new Exception(e.getMessage());
            }

        }
    }
}
