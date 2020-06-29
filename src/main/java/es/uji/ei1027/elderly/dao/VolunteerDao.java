package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Elderly;
import es.uji.ei1027.elderly.model.SocialWorker;
import es.uji.ei1027.elderly.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VolunteerDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Add Elderly to the db
    public void addVolunteer(Volunteer volunteer) {
        jdbcTemplate.update("INSERT INTO volunteer VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                volunteer.getName(), volunteer.getPhoneNumber(), volunteer.getUserV(), volunteer.getEmail(), volunteer.getPwd(), volunteer.getHobbies(),
                volunteer.getApplicationDate(), volunteer.getAcceptationDate(), volunteer.getFinalDate(), volunteer.isAccepted(), volunteer.getBirthDate());
    }

    //Delete elderly from db
    public void deleteVolunteer(String userV) {
        jdbcTemplate.update("DELETE FROM volunteer WHERE userV = ?", userV);
    }


    //Update elderly

    //Obtener Elderly por el nombre
    public Volunteer getVolunteer(String userV) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM volunteer WHERE userV = ?", new VolunteerRowMapper(), userV);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }



    //Obtener todos los volunteer
    public List<Volunteer> getVolunteers() {
        try {
            return jdbcTemplate.query("SELECT * FROM volunteer", new VolunteerRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Volunteer>();
        }
    }
}
