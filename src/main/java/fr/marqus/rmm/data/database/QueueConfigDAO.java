package fr.marqus.rmm.data.database;

import fr.marqus.rmm.data.api.DatabaseConnection;
import fr.marqus.rmm.data.model.QueueConfigRaw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class QueueConfigDAO {

    private static final String SELECT_ALL_REQUEST = "SELECT LABEL, HOST, PORT, NAME, TYPE, LOGIN, PASSWORD FROM RMM_QUEUECONFIG";

    private static final String INSERT_CONFIG_REQUEST = "INSERT INTO RMM_QUEUECONFIG(LABEL, HOST, PORT, NAME, TYPE, LOGIN, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_CONFIG_REQUEST = "UPDATE RMM_QUEUECONFIG SET HOST = ?, PORT = ?, NAME = ?, TYPE = ?, LOGIN = ?, PASSWORD = ? WHERE LABEL = ?";

    private static final String DELETE_CONFIG_REQUEST = "DELETE FROM RMM_QUEUECONFIG WHERE LABEL = ?";

    public List<QueueConfigRaw> getQueueConfigs() {
        List<QueueConfigRaw> queueConfigs = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(SELECT_ALL_REQUEST)) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                queueConfigs.add(new QueueConfigRaw(
                        result.getString("LABEL"),
                        result.getString("HOST"),
                        result.getInt("PORT"),
                        result.getString("NAME"),
                        result.getString("LOGIN"),
                        result.getString("PASSWORD"),
                        result.getString("TYPE")
                ));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return queueConfigs;
    }

    public int addQueueConfig(final QueueConfigRaw queueConfig) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(INSERT_CONFIG_REQUEST)) {
            ps.setString(1, queueConfig.queueLabel());
            ps.setString(2, queueConfig.rabbitServerPath());
            ps.setInt(3, queueConfig.rabbitServerPort());
            ps.setString(4, queueConfig.queueName());
            ps.setString(5, queueConfig.queueType());
            ps.setString(6, queueConfig.rabbitLogin());
            ps.setString(7, queueConfig.rabbitPassword());
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateQueueConfig(final QueueConfigRaw queueConfig) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(UPDATE_CONFIG_REQUEST)) {
            ps.setString(1, queueConfig.rabbitServerPath());
            ps.setInt(2, queueConfig.rabbitServerPort());
            ps.setString(3, queueConfig.queueName());
            ps.setString(4, queueConfig.queueType());
            ps.setString(5, queueConfig.rabbitLogin());
            ps.setString(6, queueConfig.rabbitPassword());
            ps.setString(7, queueConfig.queueLabel());
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteQueueConfig(final String label) {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(DELETE_CONFIG_REQUEST)) {
            ps.setString(1, label);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
