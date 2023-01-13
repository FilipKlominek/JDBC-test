package cz.educanet.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class publishersBean {

    public List<String> getPublishers() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT p.publisher_name" +
                        " FROM superhero.publisher AS p"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> publishers = new ArrayList<>();

        while (resultSet.next()) {
            publishers.add(resultSet.getString(1));
        }
        connection.close();
        return publishers;
    }
}
