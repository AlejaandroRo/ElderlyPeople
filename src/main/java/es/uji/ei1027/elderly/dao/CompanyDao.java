package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Company;
import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class CompanyDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Add company
    public void addCompany(Company company) {
        jdbcTemplate.update("INSERT INTO company VALUES(?,?,?,?,?,?,?)",
                company.getName(), company.getCif(), company.getAddress(), company.getContractPersonName(), company.getContactPersonPhoneNumber(),
                company.getContactPersonEmail(), company.getServiceType());
    }

    //Delete company from db
    public void deleteCompany(String cif) {
        jdbcTemplate.update("DELETE FROM company WHERE cif = ?", cif);
    }

    //Update company
    public void updateCompany(Company company) {
        jdbcTemplate.update("UPDATE company SET name=?, cif=?, address=?, contactPersonName=?, contactPersonPhoneNumber=?," +
                        " contactPersonEmail=?, serviceType=? WHERE cif=?",
                company.getName(), company.getCif(), company.getAddress(), company.getContractPersonName(),
                company.getContactPersonPhoneNumber(),company.getContactPersonEmail(), company.getServiceType(), company.getCif());
    }
    //Obtener Company por el nombre
    public Company getCompanyByName(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM company WHERE name = ?", new CompanyRowMapper(), name);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    //Obtener company por el cif
    public Company getCompanyByCif(String cif) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM company WHERE cif = ?", new CompanyRowMapper(), cif);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    //Obtener todos las company
    public List<Company> getCompanies() {
        try {
            return jdbcTemplate.query("SELECT * FROM company", new CompanyRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Company>();
        }
    }

}
