package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ElderlyRowMapper implements RowMapper<Elderly> {
    public Elderly mapRow(ResultSet rs, int rowNum) throws SQLException {
        Elderly elderly = new Elderly();
        elderly.setName(rs.getString("name"));
        elderly.setDni(rs.getString("dni"));
        elderly.setSurname(rs.getString("surname"));
        elderly.setBirthDate(rs.getDate("birthDate"));
        elderly.setPhoneNumber(rs.getInt("phoneNumber"));
        elderly.setBankAccountNumber(rs.getString("bankAccountNumber"));
        elderly.setEmail(rs.getString("email"));
        elderly.setUserPwd(rs.getString("userPwd"));
        elderly.setDateCreation(rs.getDate("dateCreation"));
        elderly.setAlergies(rs.getString("alergies"));
        elderly.setDiseases(rs.getString("diseases"));
        elderly.setAddress(rs.getString("address"));
        elderly.setUserCAS(rs.getString("userCAS"));
        return elderly;
    }
}
