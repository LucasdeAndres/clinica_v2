package com.example.ClinicaV2.repository;

import com.example.ClinicaV2.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class OdontologoDaoH2 implements Dao<Odontologo>{
    private static final Logger logger = LogManager.getLogger(OdontologoDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/odontologo;INIT=RUNSCRIPT FROM 'create1.sql'";

    @Override
    public Odontologo add(Odontologo odontologo) {
        Connection connection = null;


        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO (NOMBRE,APELLIDO,MATRICULA) VALUES (?,?,?)");
            preparedStatement.setString(1,odontologo.getNombre());
            preparedStatement.setString(2,odontologo.getApellido());
            preparedStatement.setLong(3,odontologo.getMatricula());

            preparedStatement.execute();

            logger.info("Se agrego un odontologo a la base de datos");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }



    @Override
    public void remove(Long id) {



        try {

            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ODONTOLOGO WHERE ID = ?");
            preparedStatement.setLong(1,id);

            preparedStatement.execute();
            preparedStatement.close();

            logger.info("Se elimino un odontologo a la base de datos");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Odontologo update(Odontologo odontologo, Long id) {



        try {

            Connection connection = getConnection();



            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ODONTOLOGO SET NOMBRE = ?, APELLIDO = ?, MATRICULA=? WHERE ID=?");
            preparedStatement.setString(1,odontologo.getNombre());
            preparedStatement.setString(2,odontologo.getApellido());
            preparedStatement.setLong(3,odontologo.getMatricula());
            preparedStatement.setLong(4,id);

            preparedStatement.executeUpdate();

            logger.info("Se modifico un odontologo a la base de datos");

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }

    @Override
    public void search(Long id) {


        Odontologo odontologo = null;

        try {

            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGO WHERE ID=?");
            preparedStatement.setLong(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idOndontologo = result.getLong(1);
                String nombre = result.getString(2);
                String apellido = result.getString(3);
                Long matricula = result.getLong(4);
                System.out.println(idOndontologo + " " + nombre + " " + apellido + " " + matricula);
            }

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void serachAll() {




        try {

            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGO");


            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idOndontologo = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Long matricula = result.getLong("matricula");
                System.out.println(idOndontologo + " " + nombre + " " + apellido + " " + matricula);

            }

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL);
    }
}
