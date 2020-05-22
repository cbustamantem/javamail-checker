package mail.test;

import mail.test.reader.InputReaderScanner;

/**
 * This is a test mail sender utility for JavaMail.
 */
public class Main {

    InputReaderScanner scanner = new InputReaderScanner();

    public static void main(String[] args) throws Exception {
        new Main().testSend();
    }
    private void testSend(){
        EmailSettings settings = prepareSettings();
                
        getSender().sendMail(settings, 
                scanner.read("subject"), 
                scanner.read("body"));
        
    }
    private EmailSender getSender(){
        EmailSender sender;
        String mecanismo = scanner.read("TLS / SSL");
        if(mecanismo.toLowerCase().contains("tls")){
            sender= new TLSEmail();
        }
        else if(mecanismo.toLowerCase().contains("ssl")){
            sender = new SSLEmail();
        }
        else{
            throw new IllegalArgumentException("the email sender type must be SSL / TLS");
        }
        return sender;
    }

    private EmailSettings prepareSettings() {
        System.out.println("Please enter the email settings ");
        EmailSettings settings = new EmailSettings(
                scanner.read("emailFrom"),
                scanner.read("senderName"),
                scanner.read("emailTo"),
                scanner.read("hostName"),
                scanner.read("port"),
                scanner.read("password"));
        return settings;
    }

}
