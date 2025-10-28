package Models;

public class Personne {
    private int num;
    private String nom;
    private String prenom;

    public Personne(int num, String nom, String prenom) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getter for num
    public int getNum() {
        return num;
    }

    // Setter for num
    public void setNum(int num) {
        this.num = num;
    }

    // Getter for nom
    public String getNom() {
        return nom;
    }

    // Setter for nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter for prenom
    public String getPrenom() {
        return prenom;
    }

    // Setter for prenom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
