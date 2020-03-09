package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.SocialWorker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class SocialWorkerRowMapper implements RowMapper<SocialWorker> {
    public SocialWorker mapRow(ResultSet rs, int rowNum) throws SQLException {
        SocialWorker socialWorker = new SocialWorker();
        socialWorker.setName(rs.getString("name"));
        socialWorker.setUserCAS(rs.getString("userCAS"));
        socialWorker.setPwd(rs.getString("pwd"));
        socialWorker.setPhoneNumber(rs.getInt("phoneNumber"));
        socialWorker.setEmail(rs.getString("email"));
        return socialWorker;
    }
}
