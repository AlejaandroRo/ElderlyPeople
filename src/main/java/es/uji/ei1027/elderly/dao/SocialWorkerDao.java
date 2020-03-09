package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Elderly;
import es.uji.ei1027.elderly.model.SocialWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SocialWorkerDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Add SocialWorker to the db
    public void addSocialWorker(SocialWorker socialWorker) {
        jdbcTemplate.update("INSERT INTO socialworker VALUES(?, ?, ?, ?, ?)",
                socialWorker.getName(), socialWorker.getUserCAS(), socialWorker.getPwd(), socialWorker.getPhoneNumber(), socialWorker.getEmail());
    }

    //Delete SocialWorker from db
    public void deleteSocialWorker(String userCAS) {
        jdbcTemplate.update("DELETE FROM socialworker WHERE userCAS = ?", userCAS);
    }

    //Get SocialWorker by UserCAS
    public SocialWorker getSocialWorker(String userCAS) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM socialworker WHERE userCAS = ?", new SocialWorkerRowMapper(), userCAS);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    //Obtener todos los elderly
    public List<SocialWorker> getSocialWorkers() {
        try {
            return jdbcTemplate.query("SELECT * FROM socialworker", new SocialWorkerRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<SocialWorker>();
        }
    }
}
