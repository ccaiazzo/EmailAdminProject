import java.util.Locale;
import java.util.*;
public class Email {
    private String password;
    private String company;
    private String firstName;
    private String lastName;
    private String address;
    private int mailBoxCapacity = 150;

    public Email(String firstName, String lastName, String department, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        String noSpaceCompany = company.replaceAll("\\s", "").toLowerCase();
        this.company = noSpaceCompany;

        char[] nameArray = firstName.toCharArray();
        String firstInitial = String.valueOf(nameArray[0]).toLowerCase();
        this.address = firstInitial + lastName.toLowerCase() + "@" + this.company + "." + department + ".org";

        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder stbuilder = new StringBuilder();
        Random random = new Random();
        while(stbuilder.length() < 30) {
            int index = (int) (random.nextFloat() * stbuilder.length());
            stbuilder.append(alphaNumeric.charAt(index));
        }
        password = stbuilder.toString();
    }

    public void setPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like the new password to be?");
        String newPassword = sc.nextLine();
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }

    public String getAddress() {
        System.out.println("The email address is " + address);
        return this.address;
    }

    public int getMailBoxCapacity() {
        System.out.println("The mailbox capacity is " + mailBoxCapacity);
        return this.mailBoxCapacity;
    }

    public String getName() {
        System.out.println("The user's name is " + firstName + " " + lastName);
        String fullName = firstName + " " + lastName;
        return fullName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

