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
        System.out.println("Buscando al casManager en la bbdd");
        try {
            System.out.println("Buscando al casManager en la bbdd");
            return jdbcTemplate.queryForObject("SELECT * FROM casManager WHERE username = ?", new CasManagerRowMapper(), userName);
        }
        catch(EmptyResultDataAccessException e) {
            System.out.println("No va bro");
            return null;
        }
    }
}
