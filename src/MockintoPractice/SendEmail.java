package MockintoPractice;

/**
 * @author aichi
 * @version 12 Jun 2025
 *
 */
public interface SendEmail {
    
    /**
     * @param to
     * @param subject
     * @param body
     */
    void send(String to, String subject, String body);
    //mock(SendEmail.class);
}
