package com.example.ClinicaV2.repository;

import com.example.ClinicaV2.model.Odontologo;
import com.example.ClinicaV2.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PacienteDaoH2 implements Dao<Paciente>{
    private static final Logger logger = LogManager.getLogger(PacienteDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/paciente;INIT=RUNSCRIPT FROM 'create2.sql'";

    @Override
    public Paciente add(Paciente paciente) {
        Connection connection = null;


        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PACIENTE (NOMBRE,APELLIDO,EMAIL,DNI,FECHAINGRESO) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3,paciente.getEmail());
            preparedStatement.setString(4,paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));

            preparedStatement.execute();

            logger.info("Se agrego un paciente la base de datos");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }



    @Override
    public void remove(Long id) {



        try {

            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PACIENTE WHERE ID = ?");
            preparedStatement.setLong(1,id);

            preparedStatement.execute();
            preparedStatement.close();

            logger.info("Se elimino un paciente de la base de datos");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Paciente update(Paciente paciente, Long id) {



        try {

            Connection connection = getConnection();



            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PACIENTE SET NOMBRE = ?, APELLIDO = ?, EMAIL=?, DNI=?, FECHAINGRESO=? WHERE ID=?");
            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3,paciente.getEmail());
            preparedStatement.setString(4,paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));

            preparedStatement.executeUpdate();

            logger.info("Se modifico un paciente a la base de datos");

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }

    @Override
    public void search(Long id) {


        Paciente paciente = null;

        try {

            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTE WHERE ID=?");
            preparedStatement.setLong(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idPaciente = result.getLong(1);
                String nombre = result.getString(2);
                String apellido = result.getString(3);
                String email = result.getString("email");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha de Ingreso");
                System.out.println(idPaciente + " " + nombre + " " + apellido + " " + email + " " + dni + " " + fechaIngreso);
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

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTE");


            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Long idPaciente = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha de Ingreso");
                System.out.println(idPaciente + " " + nombre + " " + apellido + " " + email + " " + dni + " " + fechaIngreso);

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
