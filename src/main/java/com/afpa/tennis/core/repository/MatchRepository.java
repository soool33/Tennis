package com.afpa.tennis.core.repository;

import com.afpa.tennis.core.DataSourceProvider;
import com.afpa.tennis.core.entity.Match;

import javax.sql.DataSource;
import java.sql.*;

public class MatchRepository {
    public void create(Match match) {
        Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDatasource();
            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO MATCH_TENNIS (ID_EPREUVE, ID_VAINQUEUR, ID_FINALISTE) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, match.getEpreuve().getId());
            preparedStatement.setLong(2, match.getVainqueur().getId());
            preparedStatement.setLong(3, match.getFinaliste().getId());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                match.setId(rs.getLong(1));
            }

            System.out.println("Joueur Créé");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

