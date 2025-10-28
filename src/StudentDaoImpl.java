import Interfaces.StudentDao;
import Models.MySqlConnection;
import Models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO student (firstName, lastName, average) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDouble(3, student.getAverage());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                student.setId(rs.getInt(1));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(Student student) {
        return false;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
