package mail.test;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmail  implements EmailSender{

	public boolean sendMail(final EmailSettings settings, String subject, String body) {
				
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", settings.getHostName()); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
                props.put("mail.smtp.ssl.trust", "*");
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(settings.getEmailFrom(), settings.getPassword());
			}
		};
		Session session = Session.getInstance(props, auth);
		
		return EmailUtil.sendEmail(session, settings, subject,body);
	}

	
}