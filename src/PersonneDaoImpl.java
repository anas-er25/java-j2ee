import Interfaces.PersonneDao;
import Interfaces.StudentDao;
import Models.MySqlConnection;
import Models.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonneDaoImpl implements PersonneDao {
    @Override
    public Personne save(Personne personne) {
        Connection c = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO personne (nom,prenom) VALUES (?,?); ", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, personne.getNom());
            ps.setString(2, personne.getPrenom());
            ps.executeUpdate();
            ResultSet resultat = ps.getGeneratedKeys();
            if (resultat.next()) {
                personne.setNum(resultat.getInt(1));
                return personne;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(Personne personne) {
        return false;
    }

    @Override
    public Personne update(Personne personne) {
        return null;
    }

    @Override
    public Personne findById(int id) {
        Personne personne = null;
        Connection c = MySqlConnection.getConnection();
        if (c != null) {
            try {
                String request = "SELECT * FROM personne WHERE num = ?;"; PreparedStatement ps = c.prepareStatement(request);
                ps.setInt(1, id);
                ResultSet r = ps.executeQuery(); if
                (r.next())
                    personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personne;
    }


    @Override
    public List<Personne> getAll() {
        return List.of();
    }
}
