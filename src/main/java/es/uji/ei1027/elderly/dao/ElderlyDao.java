package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class ElderlyDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Add Elderly to the db
    public void addElderly(Elderly elderly) {
        jdbcTemplate.update("INSERT INTO elderly VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                            elderly.getName(), elderly.getDni(),elderly.getSurname(), elderly.getBirthDate(), elderly.getPhoneNumber(), elderly.getBankAccountNumber(),
                            elderly.getEmail(), elderly.getUserPwd(), elderly.getDateCreation(), elderly.getAlergies(), elderly.getDiseases(), elderly.getAddress(), elderly.getUserCAS());
    }

    //Delete elderly from db
    public void deleteElderly(String dni) {
        jdbcTemplate.update("DELETE FROM elderly WHERE dni = ?", dni);
    }

    //Update elderly
    public void updateElderly(Elderly elderly) {
        jdbcTemplate.update("UPDATE elderly SET name=?, surname=?, birthDate=?, phoneNumber=?, bankAccountNumber=?, email=?, userPwd=?, dateCreation=?," +
                        " alergies=?, diseases=?, address=?, userCAS=? WHERE dni=?",
                elderly.getName(),elderly.getSurname(), elderly.getBirthDate(), elderly.getPhoneNumber(), elderly.getBankAccountNumber(),
                elderly.getEmail(), elderly.getUserPwd(), elderly.getDateCreation(), elderly.getAlergies(), elderly.getDiseases(), elderly.getAddress(), elderly.getUserCAS(), elderly.getDni());
    }
    //Obtener Elderly por el nombre
    public Elderly getElderlyByName(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM elderly WHERE name = ?", new ElderlyRowMapper(), name);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    //Obtener elderly por el dni
    public Elderly getElderlyByDni(String dni) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM elderly WHERE dni = ?", new ElderlyRowMapper(), dni);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    //Obtener todos los eldely
    public List<Elderly> getElderlies() {
        try {
            return jdbcTemplate.query("SELECT * FROM elderly", new ElderlyRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Elderly>();
        }
    }
}
