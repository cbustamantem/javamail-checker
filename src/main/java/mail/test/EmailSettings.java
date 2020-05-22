package mail.test;

public class EmailSettings {

    private String emailFrom;
    private String senderName;
    private String emailTo;
    private String hostName;
    private String port;
    private String password;

    public EmailSettings() {
    }

    public EmailSettings(String emailFrom, String senderName, String emailTo, String hostName, String port, String password) {
        this.emailFrom = emailFrom;
        this.senderName = senderName;
        this.emailTo = emailTo;
        this.hostName = hostName;
        this.port = port;
        this.password = password;
    }

    public String getSenderName() {
        return senderName;
    }

    

    public String getEmailFrom() {
        return emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public String getHostName() {
        return hostName;
    }

    public String getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

}
