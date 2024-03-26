import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Department department = new Department(1, "Finance");

        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/departments", "kalyani", "kalyani123");

            // Create a statement
            Statement statement = connection.createStatement();

            // Insert department data into the database
            String query = "INSERT INTO department (id, name) VALUES (" + department.getId() + ", '" + department.getName() + "')";
            statement.executeUpdate(query);

            // Close resources
            statement.close();
            connection.close();

            System.out.println("Department data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}