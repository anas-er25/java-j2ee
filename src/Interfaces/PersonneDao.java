package Interfaces;

import Models.Personne;

import java.util.List;

public interface PersonneDao {
    Personne save(Personne personne);
    boolean remove(Personne personne);
    Personne update(Personne personne);
    Personne findById(int id);
    List<Personne> getAll();
}
