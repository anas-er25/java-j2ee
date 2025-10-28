import Models.Personne;
import Models.Student;

public class Main {
    public static void main(String args []) {
        PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
        Personne personne = new Personne (2, "D'HIMEN", "Hatim");
        Personne insertedPersonne = personneDaoImpl.save(personne);

        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student student = new Student ("Ahmed", "ALAMI", 16);
        Student insertedStudent = studentDao.save(student);

        if (insertedStudent != null || insertedPersonne != null) {
            System.out.println("personne numéro " + insertedPersonne.getNum() + " a été insérée");
            System.out.println("Étudiant ajouté avec ID : " + insertedStudent.getId());

        } else {
            System.out.println("problème d'insertion");
        }
    }
}
