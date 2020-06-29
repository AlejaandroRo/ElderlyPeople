package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Volunteer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public final class VolunteerRowMapper implements RowMapper<Volunteer> {
    public Volunteer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Volunteer volunteer = new Volunteer();
        volunteer.setName(rs.getString("name"));
        volunteer.setUserV(rs.getString("userV"));
        volunteer.setPhoneNumber(rs.getInt("phoneNumber"));
        volunteer.setEmail(rs.getString("email"));
        volunteer.setApplicationDate(rs.getObject("applicationDate", LocalDate.class));
        return volunteer;
    }
}
