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

    //Obtener todos los eldely
    public List<SocialWorker> getSocialWorkers() {
        try {
            return jdbcTemplate.query("SELECT * FROM socialworker", new SocialWorkerRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<SocialWorker>();
        }
    }
}
