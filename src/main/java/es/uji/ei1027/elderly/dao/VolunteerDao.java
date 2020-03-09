package es.uji.ei1027.elderly.dao;

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

    //BORRAR VOLUNTEER
    public void deleteVolunteer(String userV) {
        jdbcTemplate.update("DELETE FROM volunteer WHERE userv = ?",
                userV);
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
