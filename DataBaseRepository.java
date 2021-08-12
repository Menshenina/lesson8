package lesson7;

import lesson7.emtity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    String insertWeather = "insert into weather (day, minTemp , maxTemp ) values (?, ?, ?)";
    String selectWeather = "select * from weather";
    private static final String  DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e){
            e.printStackTrace();;
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try(Connection connection = DriverManager.getConnection(DB_PATH)){
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getDay());
            saveWeather.setDouble(2, weather.getMinTemp());
            saveWeather.setDouble(3, weather.getMaxTemp());
            return saveWeather.execute();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        throw  new SQLException("Погода не сохранена");
    }

    public List<Weather> getSaveTODBWeather() {
        try(Connection connection = DriverManager.getConnection(DB_PATH)){
            Statement readWeather = connection.createStatement();

            ResultSet resultSet = readWeather.executeQuery(selectWeather);
            List<Weather> result = new ArrayList<Weather>();
            while (resultSet.next()){
                Weather w = new Weather(resultSet.getString("day"),
                        resultSet.getDouble("minTemp"),
                        resultSet.getDouble("maxTemp"));
                result.add(w);
            }

            return result;

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }
}
