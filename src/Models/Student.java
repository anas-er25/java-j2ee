package Models;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double average;

    public Student(int id, String firstName, String lastName, double average) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
    }

    public Student(String firstName, String lastName, double average) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getAverage() { return average; }
    public void setAverage(double average) { this.average = average; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", average=" + average +
                '}';
    }
}
