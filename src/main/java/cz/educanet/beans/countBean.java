package cz.educanet.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class countBean {
    List<Count> getCounts() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT p.publisher_name, COUNT(s.id)" +
                        " FROM superhero.publisher AS p" +
                        " JOIN superhero.superhero AS s ON (s.publisher_name = p.id)" +
                        " GROUP BY p.id"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Count> counts = new ArrayList<>();

        while (resultSet.next()) {
            counts.add(new Count(
                    resultSet.getString(1),
                    resultSet.getInt(2)
            ));
        }
        connection.close();
        return counts;
    }
}
