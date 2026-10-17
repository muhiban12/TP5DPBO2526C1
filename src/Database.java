import java.sql.*;

public class Database {
    private Connection connection;
    private Statement statement;

    // Constructor untuk inisialisasi koneksi MySQL
    public Database() {
        try {
            // Sesuaikan URL, Username, dan Password MySQL milikmu
            String url = "jdbc:mysql://localhost:3306/db_people";
            String user = "root";
            String password = ""; // Kosongkan jika menggunakan XAMPP standar

            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Koneksi Database Gagal: " + e.getMessage());
        }
    }

    // Method untuk mengeksekusi SELECT query
    public ResultSet selectQuery(String sql) {
        try {
            statement.executeQuery(sql);
            return statement.getResultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method untuk mengeksekusi INSERT, UPDATE, dan DELETE query
    public int insertUpdateDeleteQuery(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Getter Statement
    public Statement getStatement() {
        return statement;
    }
}