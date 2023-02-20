public class EmailApp {

    public static void main(String[] args) {
        // main application class
        Email email1 = new Email("Ryan", "Smith");

        email1.setMailboxCapacity(2000);
        email1.setAlternateEmail("testEmail@junk.com");

        System.out.println(email1.showInfo());
    }
}
