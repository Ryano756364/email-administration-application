import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 16;
    private String department;
    private String email;
    private String companySuffix = "ryanpodell.com";
    private int mailboxCapacity;
    private String alternateEmail;

    //Need constructor to receive the first name and last name of the user
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created for: " + this.firstName + " " + this.lastName);

        //Now call a private method asking for dept and returning department
        this.department = setDepartment();
        System.out.println(this.department != null ? "Department chosen is: " + this.department : "No department chosen.");

        // Call a private method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your default password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." +
                lastName.toLowerCase() + "@" +
                (department != null ? department.toLowerCase() + "." : "") +
                companySuffix;
        System.out.println("Your email is: " + email);
    }

    //Need to ask what department they are in
    private String setDepartment(){
        System.out.println("""
                Enter the department code for employee
                1 for Sales
                2 for Development
                3 for Accounting
                0 for none""");
        Scanner input = new Scanner(System.in);
        int deptChoice = input.nextInt();
        return switch (deptChoice) {
            case 1 -> "Sales";
            case 2 -> "Development";
            case 3 -> "Accounting";
            default -> null;
        };
    }

    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            //random number logic
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set an alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail; //this. not necessarily needed since there's no parameter ambiguity
    }

    //Ability to change password
    public void changePassword(String password){
        this.password = password;
    }

}
