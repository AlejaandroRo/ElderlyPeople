package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Volunteer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class VolunteerRowMapper implements RowMapper<Volunteer> {
    public Volunteer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Volunteer volunteer = new Volunteer();
        volunteer.setName(rs.getString("name"));
        volunteer.setUserV(rs.getString("userV"));
        volunteer.setPhoneNumber(rs.getInt("phoneNumber"));
        volunteer.setEmail(rs.getString("email"));
        volunteer.setApplicationDate(rs.getDate("date"));
        return volunteer;
    }
}
