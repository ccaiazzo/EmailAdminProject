import java.util.Locale;
import java.util.*;
public class Email {
    private String password; // Instance variables
    private String company;
    private String firstName;
    private String lastName;
    private String address;
    private int mailBoxCapacity = 150;

    public Email(String firstName, String lastName, String department, String company) { // Default constructor
        this.firstName = firstName;
        this.lastName = lastName;
        String noSpaceCompany = company.replaceAll("\\s", "").toLowerCase(); // Takes string and removes spaces, converts to lower case
        this.company = noSpaceCompany;

        char[] nameArray = firstName.toCharArray(); // Takes first name and separates first letter to append to email address
        String firstInitial = String.valueOf(nameArray[0]).toLowerCase();
        this.address = firstInitial + lastName.toLowerCase() + "@" + this.company + "." + department + ".org"; // Full email address is assembled

        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"; // String that contains possible characters for random password
        StringBuilder stbuilder = new StringBuilder(); // Creates empty StringBuilder object that will be filled with random characters
        Random random = new Random();
        while(stbuilder.length() < 30) { // While loop that determines how many characters are included in random password; in this case 30
            int index = (int) (random.nextFloat() * stbuilder.length()); // Code that determines random index in alphaNumeric string to pull from
            stbuilder.append(alphaNumeric.charAt(index)); // Random character is appended to StringBuilder
        }
        password = stbuilder.toString(); // StringBuilder is converted to usable String and becomes password variable
    }

    public void setPassword() { // Takes input from user to set new password
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like the new password to be?");
        String newPassword = sc.nextLine();
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }

    public String getAddress() { // Returns address string variable
        System.out.println("The email address is " + address);
        return this.address;
    }

    public int getMailBoxCapacity() { // Returns int for mailbox capacity
        System.out.println("The mailbox capacity is " + mailBoxCapacity);
        return this.mailBoxCapacity;
    }

    public String getName() { // Returns user's name as string
        System.out.println("The user's name is " + firstName + " " + lastName);
        String fullName = firstName + " " + lastName;
        return fullName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // New scanner object

        System.out.println("What's your first name?");
        String firstName = scanner.nextLine();

        System.out.println("What's your last name?");
        String lastName = scanner.nextLine();

        System.out.println("What company do you work for?");
        String companyName = scanner.nextLine();

        System.out.println("What department are you in?");
        String deptName = scanner.nextLine().toLowerCase();

        Email chris = new Email(firstName, lastName, deptName, companyName);
        chris.getAddress();
        chris.getName();
        chris.getMailBoxCapacity();
        System.out.println(chris.password);
        chris.setPassword();
    }
}

