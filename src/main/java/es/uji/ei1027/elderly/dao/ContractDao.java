package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Company;
import es.uji.ei1027.elderly.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //AddContract
    public void addContract(Contract contract) {
        jdbcTemplate.update("INSERT INTO contract VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", contract.getNumber(), contract.getDateBeginning(),
                contract.getDateEnding(), contract.getDescription(), contract.getServiceType(), contract.getQuantityServices(),
                contract.getUnitsOfMeasure(), contract.getPriceUnit(), contract.getCifCompany());
    }

    //DeleteContract
    public void deleteContract(int number) {
        jdbcTemplate.update("DELETE FROM contract WHERE number = ?", number);
    }

    //UpdateContract
    public void updateContract(Contract contract) {
        jdbcTemplate.update("UPDATE contract SET number=?, dateBeginning=?, dateEnding=?, description=?, serviceType=?, quantityServices=?," +
                " unitsOfMeasure=?, priceUnit=?, cifCompany=? WHERE number=?", contract.getNumber(), contract.getDateBeginning(),
                contract.getDateEnding(), contract.getDescription(), contract.getServiceType(), contract.getQuantityServices(),
                contract.getUnitsOfMeasure(), contract.getPriceUnit(), contract.getCifCompany(), contract.getNumber());
    }

    //Obtener contract por numero
    public Contract getContractByNumber(int number) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM contract WHERE number = ?", new ContractRowMapper(), number);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    //Obtener todos los contracts de una company
    public List<Contract> getContractsByCompany(String cifCompany) {
        try {
            return jdbcTemplate.query("SELECT * FROM contract WHERE cifCompany=?", new ContractRowMapper(), cifCompany);
        } catch(EmptyResultDataAccessException e) {
            return new ArrayList<Contract>();
        }
    }

    //Obtener todos los contracts de un tipo de servicio concreto
    public List<Contract> getContractsByServiceType(String serviceType) {
        try {
            return jdbcTemplate.query("SELECT * FROM contract WHERE serviceType=?", new ContractRowMapper(), serviceType);
        } catch(EmptyResultDataAccessException e) {
            return new ArrayList<Contract>();
        }
    }

    //List
    public List<Contract> getContracts() {
        try {
            return jdbcTemplate.query("SELECT * FROM contract", new ContractRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Contract>();
        }
    }

}
