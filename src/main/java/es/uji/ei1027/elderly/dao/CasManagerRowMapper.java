package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.CasManager;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class CasManagerRowMapper implements RowMapper<CasManager> {
    public CasManager mapRow(ResultSet rs, int rowNum) throws SQLException {
        CasManager casManager = new CasManager();
        casManager.setUsername(rs.getString("username"));
        casManager.setPwd(rs.getString("pwd"));
        return casManager;
    }
}
