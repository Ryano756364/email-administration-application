import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    //Need constructor to receive the first name and last name of the user
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created for: " + this.firstName + " " + this.lastName);

        //Now call a private method asking for dept and returning department
        this.department = setDepartment();
        System.out.println("Department chosen is: " + this.department);

        // Call a private method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your default password is " + this.password);
    }

    //Need to ask what department they are in
    private String setDepartment(){
        System.out.println("""
                Enter the department code for employee
                1 for Sales\s
                2 for Development
                3 for Accounting
                0 for none\s""");
        Scanner input = new Scanner(System.in);
        int deptChoice = input.nextInt();
        return switch (deptChoice) {
            case 1 -> "Sales";
            case 2 -> "Development";
            case 3 -> "Accounting";
            default -> "";
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

    //Set an alternate email

    //Ability to change password

}
