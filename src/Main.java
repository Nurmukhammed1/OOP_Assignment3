import java.net.ConnectException;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void showAllContacts(Connection connection) throws Exception
    {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM contacts");

        System.out.println();

        while (result.next())
        {
            System.out.println(result.getString("name") + ' ' + result.getString("surname") + ' ' + result.getString("phonenum"));
        }

        System.out.println();
    }

    public static void findContact(Connection connection) throws Exception
    {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM contacts");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name to find contact: ");
        String enteredName = scanner.next();

        System.out.println("Enter surname to find contact: ");
        String enteredSurname = scanner.next();

        String name = "";
        String surname = "";

        while (result.next())
        {
            name = result.getString("name");
            surname = result.getString("surname");

            if (name.equals(enteredName) && surname.equals(enteredSurname))
            {
                System.out.println();
                System.out.println(result.getString("name") + ' ' + result.getString("surname") + ' ' + result.getString("phonenum"));
                System.out.println();
                break;
            }
        }
    }

    public static void createContact(Connection connection) throws Exception
    {
        PreparedStatement ps = connection.prepareStatement("insert into contacts (name, surname, phonenum) values (?, ?, ?)");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of new contact: ");
        String enteredName = scanner.next();

        System.out.println("Enter surname of new contact: ");
        String enteredSurname = scanner.next();

        System.out.println("Enter number of new contact: ");
        String enteredNum = scanner.next();

        ps.setString(1, enteredName);
        ps.setString(2, enteredSurname);
        ps.setString(3, enteredNum);
        ps.executeUpdate();
    }

    public static void deleteContact(Connection connection) throws Exception
    {
        PreparedStatement ps = connection.prepareStatement("delete from contacts where name = ? and surname = ?");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of contact to delete: ");
        String enteredName = scanner.next();

        System.out.println("Enter surname of contact to delete: ");
        String enteredSurname = scanner.next();

        ps.setString(1, enteredName);
        ps.setString(2, enteredSurname);
        ps.executeUpdate();
    }

    public static void main(String[] args)  throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "0202");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM contacts");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Contact Book Management System!");

        while (true)
        {
            System.out.println("1. Show all contacts");
            System.out.println("2. Find an contact");
            System.out.println("3. Create contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Quit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            if (choice == 1) {
                showAllContacts(connection);
                System.out.println();
                continue;
            }
            else if (choice == 2)
            {
                findContact(connection);
                System.out.println();
                continue;
            }
            else if (choice == 3)
            {
                createContact(connection);
                System.out.println();
                continue;
            }
            else if (choice == 4)
            {
                deleteContact(connection);
                System.out.println();
                continue;
            }
            else if (choice == 5)
            {
                break;
            }
            else
            {
                System.out.println("Choose correct option!");
                continue;
            }
        }

        System.out.println("You have successfully exited the application!");
    }
}