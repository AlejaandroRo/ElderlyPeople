package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.*;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FakeUserProvider implements UserDao {
    private JdbcTemplate jdbcTemplate;
    BasicPasswordEncryptor passwordEncryptor;

    public FakeUserProvider() {
        this.passwordEncryptor = new BasicPasswordEncryptor();
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserDetails loadUserByUsername(String username, String password) {
        UserDetails user = new UserDetails();
        try {
            Elderly elderly = jdbcTemplate.queryForObject("SELECT * FROM elderly WHERE username = ?", new ElderlyRowMapper(), username);
            user.setTypeOfUser("elderly");
            user.setUsername(elderly.getUsername());
            user.setPassword(passwordEncryptor.encryptPassword((elderly.getUserPwd())));
        } catch (EmptyResultDataAccessException e){
            try {
                CasManager casManager = jdbcTemplate.queryForObject("SELECT * FROM casManager WHERE username = ?", new CasManagerRowMapper(), username);
                user.setTypeOfUser("casManager");
                user.setUsername(casManager.getUsername());
                user.setPassword(passwordEncryptor.encryptPassword(casManager.getPwd()));
            } catch (EmptyResultDataAccessException ex) {
                try {
                    CasCommitee casCommittee = jdbcTemplate.queryForObject("SELECT * FROM casCommitee WHERE username = ?", new CasCommiteeRowMapper(), username);
                    user.setTypeOfUser("casCommitee");
                    user.setUsername(casCommittee.getUsername());
                    user.setPassword(passwordEncryptor.encryptPassword(casCommittee.getPwd()));
                } catch (EmptyResultDataAccessException exc) {
                    return null;
                }
            }
        }

        // Contrasenya
        if (passwordEncryptor.checkPassword(password, user.getPassword())) {
            // Es deuria esborrar de manera segura el camp password abans de tornar-lo
            return user;
        }
        else {
            return null; // bad login!
        }
    }
}