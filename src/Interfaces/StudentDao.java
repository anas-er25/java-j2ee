package Interfaces;

import Models.Student;
import java.util.List;

public interface StudentDao extends GenericDao<Student, Integer> {
    Student save(Student student);
    boolean remove(Student student);
    Student update(Student student);
    Student findById(int id);
    List<Student> getAll();
}
