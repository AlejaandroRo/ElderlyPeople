package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository // En Spring els DAOs van anotats amb @Repository
public class ElderlyDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Añadir elderly a la base de datos
    public void addElderly(Elderly elderly) {
        jdbcTemplate.update("INSERT INTO elderly VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                            elderly.getName(), elderly.getDni(), elderly.getBirthDate(), elderly.getPhoneNumber(), elderly.getBankAccountNumber(),
                            elderly.getEmail(), elderly.getUserPwd(), elderly.getDateCreation(), elderly.getAddress(), elderly.getUserCAS());
    }

    //Borrar elderly de la base de datos
    public void deleteElderly(Elderly elderly) {
        jdbcTemplate.update("DELETE FROM elderly WHERE dni = ?", elderly.getDni());
    }


    //Actualizar atributos elderly

    //Obtener Elderly por el nombre
    public Elderly getElderly(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM elderly WHERE name = ?", new ElderlyRowMapper(), name);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    //Obtener elderly por el dni

    //Obtener todos los eldely
}
