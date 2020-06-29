package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.CasManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CasManagerDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public CasManager getCasManagerByUserName(String userName) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM casManager WHERE username = ?", new CasManagerRowMapper(), userName);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
}
