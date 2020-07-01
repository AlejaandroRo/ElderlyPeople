package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.CasCommitee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CasCommiteeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public CasCommitee getCasCommitteeByUserName(String userName) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM casCommitee WHERE username = ?", new CasCommiteeRowMapper(), userName);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
}
