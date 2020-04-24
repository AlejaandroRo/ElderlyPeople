package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class CompanyRowMapper implements RowMapper<Company> {
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setName(rs.getString("name"));
        company.setCif(rs.getString("cif"));
        company.setAddress(rs.getString("address"));
        company.setContactPersonName(rs.getString("contactPersonName"));
        company.setContactPersonPhoneNumber(rs.getInt("contactPersonPhoneNumber"));
        company.setContactPersonEmail(rs.getString("contactPersonEmail"));
        company.setServiceType(rs.getString("serviceType"));
        return company;
    }
}
