package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.CasCommitee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class CasCommiteeRowMapper implements RowMapper<CasCommitee> {
    public CasCommitee mapRow(ResultSet rs, int rowNum) throws SQLException {
        CasCommitee casCommitee = new CasCommitee();
        casCommitee.setUsername(rs.getString("username"));
        casCommitee.setPwd(rs.getString("pwd"));
        return casCommitee;
    }
}
