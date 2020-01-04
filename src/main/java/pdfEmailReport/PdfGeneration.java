package pdfEmailReport;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @author Jagatheshwaran
 *
 */
public class PdfGeneration {

	/**
	 * The below method will send the email with PDF file attachment
	 * 
	 * @param from
	 * @param pass
	 * @param to
	 * @param subject
	 * @param body
	 */
	public static void sendPDFReportByMail(String from, String pass, String to, String subject, String body)
			throws IOException {

		String testReport = System.getProperty("user.dir") + "//" + "PDFDocx" + "//" + "TestExecutionReport.pdf";
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		System.setProperty("mail.mime.encodeeol.strict", "true");
		Session session = Session.getDefaultInstance(props);
		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			// Set From Email Address
			mimeMessage.setFrom(new InternetAddress(from));

			// Set To Email Address
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Email Subject line
			mimeMessage.setSubject(subject);

			/*
			 * // Set Email body Content Text message.setText(body);
			 */

			// Declaring and initializing Body Part of Email
			BodyPart bodyPartMessage = new MimeBodyPart();

			// Set Email Body Text Content
			bodyPartMessage.setText("Please Find The Attached Test Execution Report File!");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(bodyPartMessage);

			bodyPartMessage = new MimeBodyPart();

			// Attach PDF file to Body Part
			((MimeBodyPart) bodyPartMessage).attachFile(testReport, "application/pdf", "base64");

			multipart.addBodyPart(bodyPartMessage);

			DataSource source = new FileDataSource(testReport);

			bodyPartMessage.setDataHandler(new DataHandler(source));

			bodyPartMessage.setFileName(testReport);

			multipart.addBodyPart(bodyPartMessage);

			mimeMessage.setContent(multipart);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			System.out.println("Email Sent!");

			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}

}
