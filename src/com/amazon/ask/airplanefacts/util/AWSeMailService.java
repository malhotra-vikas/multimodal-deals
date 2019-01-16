package com.amazon.ask.airplanefacts.util;
public class AWSeMailService {

}
/*
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AWSeMailService {

    private static final Logger log = LoggerFactory.getLogger(AWSeMailService.class);

    // Replace smtp_username with your Amazon SES SMTP user name.
    //static final String SMTP_USERNAME = "AKIAIWA34YF3AW5RCLEQ"; //test
    static final String SMTP_USERNAME = "AKIAJJMYZTEHULH6O6BQ"; //prod

    // Replace smtp_password with your Amazon SES SMTP password.
    // static final String SMTP_PASSWORD = "AjPmjDPoFI5kO+ujQf2PvOmNkgXTAbQ7TTnxXcHGhB+1"; //test
    static final String SMTP_PASSWORD = "Anupy5b/HSF67SQHXP8//9du6YEI5WT8K18VNutKsiZ0"; //prod


    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    // See https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";

    // The port you will connect to on the Amazon SES SMTP endpoint.
    static final int PORT = 587;

    public static void sendEmail(String from, String to, String subject, String body, String fromName) throws IOException, MessagingException {
// Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from, fromName));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setContent(body,"text/html");

        // Create a transport.
        Transport transport = session.getTransport();

        // Send the message.
        try
        {
            log.debug("Sending...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            log.debug("Email sent!");
        }
        catch (Exception ex) {
            log.debug("The email was not sent.");
            log.debug("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }

    }

}
*/