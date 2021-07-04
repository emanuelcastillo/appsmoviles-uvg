package com.example.bookside;

import android.os.AsyncTask;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailJob extends AsyncTask<MailJob.Mail, Void, String> {
    /**
     * Atributos de la clase
     */
    private final String user;
    private final String pass;

    /**
     * Constructor de la clase
     * @param user
     * @param pass
     */
    public MailJob(String user, String pass) {
        super();
        this.user=user;
        this.pass=pass;
    }

    /**
     * Metodo que envia el correo
     * @param mails
     * @return
     */
    protected String doInBackground(Mail... mails) {
        String resultado = "";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        for (Mail mail:mails) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(mail.from));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.to));
                message.setSubject(mail.subject);
                message.setText(mail.content);
                Transport.send(message);
                resultado = "exito";
            } catch (MessagingException e) {
                resultado = "error";
                e.getMessage();
            }
        }
        return resultado;
    }

    /**
     * Clase tipo pojo que define el correo
     */
    public static class Mail{
        private final String subject;
        private final String content;
        private final String from;
        private final String to;

        /**
         * Constructor de la clase
         * @param from
         * @param to
         * @param subject
         * @param content
         */
        public Mail(String from, String to, String subject, String content){
            this.subject = subject;
            this.content = content;
            this.from = from;
            this.to = to;
        }
    }
}
