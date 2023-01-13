package cz.educanet.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class superheroesBean {

    private String filter;
    public void changeFilter(String filter) {
        this.filter = filter;
    }

    public List<Superhero> getSuperheroes() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT s.superhero_name, s.full_name, g.gender, r.race, a.alignment" +
                        " FROM superhero.superhero AS s" +
                        " JOIN superhero.gender AS g ON (g.id = s.gender_id)" +
                        " JOIN superhero.race AS r ON (r.id = s.race_id)" +
                        " JOIN superhero.alignment AS a ON (a.id = s.alignment_id)"// +
                        //" JOIN superhero.publisher AS p ON (p.id = s.publisher_id)" +
                        //" WHERE p.publisher_name LIKE ?"
        );

        //preparedStatement.setString(1, filter);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Superhero> superheroes = new ArrayList<>();

        while (resultSet.next()) {
            superheroes.add(new Superhero(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        connection.close();
        return superheroes;
    }

}
