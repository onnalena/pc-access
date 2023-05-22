package com.example.pcaccess.service;

import com.example.pcaccess.configurations.PGDataSource;
import com.example.pcaccess.model.Booking;
import com.example.pcaccess.model.Computer;
import javafx.event.Event;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoginService {

    public <M> boolean isValid(Event event, final String identityNumber, final String accessToken) throws SQLException, UnknownHostException {
        Map<String, Class<?>> params = new HashMap<>();
        params.put(identityNumber, String.class);

        List<Booking> bookings = retrieve("booking", "WHERE idnumber = ?", params, Booking.class);

        if (bookings.isEmpty()) {
            TriggerAlert.alert(event, "Invalid ID Number", "Booking for user with id " + identityNumber + " was not found. \nPlease check if you entered the correct ID Number");
            return false;
        }

        Optional<Booking> accessTokenOpt = bookings.stream().filter(x -> accessToken.equals(x.getAccess_token())).findFirst();

        if (accessTokenOpt.isEmpty()) {
            TriggerAlert.alert(event, "Invalid Access Token", "Please check if you entered the correct access token");
            return false;
        }

        Map compParams = new HashMap<>();
        compParams.put(accessTokenOpt.get().getComputer_id(), Long.class);
        compParams.put(InetAddress.getLocalHost().getHostName(), String.class);

        List<Computer> computers = retrieve("computer", "WHERE id = ? and computer_name = ?", compParams, Computer.class);

        if (computers.isEmpty()) {
            TriggerAlert.alert(event, "Invalid PC", "Not booked for current PC");
            return false;
        }

        return true;
    }

    private <P, T> List<T> retrieve(final String tableName, final String clause, Map<P, Class<?>> params, final Class<T> returnType) {
        final String select = Objects.nonNull(clause) ? String.format("SELECT * FROM %s ", tableName).concat(clause)
                : String.format("SELECT * FROM %s ", tableName);

        try (Connection connection = PGDataSource.dataSource(); PreparedStatement preparedStatement =
                preparedStatement(connection.prepareStatement(select), params)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            return prepareResponse(resultSet, returnType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <P> List<P> prepareResponse(final ResultSet resultSet, Class<P> type) throws InstantiationException, IllegalAccessException, SQLException {
        List<P> results = new ArrayList<>();

        while(resultSet.next()) {
            P instance = type.newInstance();
            Arrays.stream(instance.getClass().getDeclaredFields()).forEach(x -> {
                try {
                    x.setAccessible(true);
                    x.set(instance, resultSet.getObject(x.getName(), x.getType()));
                    x.setAccessible(false);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                x.setAccessible(false);
            });
            results.add(instance);
        }
        return results;
    }

    private <P> PreparedStatement preparedStatement(final PreparedStatement preparedStatement, final Map<P, Class<?>> params) {
        AtomicInteger paramIndex = new AtomicInteger(1);
        params.forEach((key, value) -> {
            try {
                if (value.equals(String.class)) {
                    preparedStatement.setString(paramIndex.get(), (String) key);
                }
                if (value.equals(Long.class)) {
                    preparedStatement.setLong(paramIndex.get(), (Long) key);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            paramIndex.getAndIncrement();
        });
        return preparedStatement;
    }
}
