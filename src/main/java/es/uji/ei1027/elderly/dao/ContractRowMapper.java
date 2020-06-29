package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Company;
import es.uji.ei1027.elderly.model.Contract;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public final class ContractRowMapper implements RowMapper<Contract> {
    public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contract contract = new Contract();
        contract.setNumber(rs.getInt("number"));
        contract.setDateBeginning(rs.getObject("dateBeginning", LocalDate.class));
        contract.setDateEnding(rs.getObject("dateEnding", LocalDate.class));
        contract.setDescription(rs.getString("description"));
        contract.setServiceType(rs.getString("serviceType"));
        contract.setQuantityServices(rs.getInt("quantityService"));
        contract.setUnitsOfMeasure(rs.getString("unitsOfMeasure"));
        contract.setPriceUnit(rs.getDouble("priceUnit"));
        contract.setCifCompany(rs.getString("cifCompany"));
        return contract;
    }
}
