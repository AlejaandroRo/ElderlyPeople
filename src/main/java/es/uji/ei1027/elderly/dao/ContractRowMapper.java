package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Company;
import es.uji.ei1027.elderly.model.Contract;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ContractRowMapper implements RowMapper<Contract> {
    public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contract contract = new Contract();
        contract.setNumber(rs.getInt("number"));
        contract.setDateBeginning(rs.getDate("dateBeginning"));
        contract.setDateEnding(rs.getDate("dateEnding"));
        contract.setDescription(rs.getString("description"));
        contract.setServiceType(rs.getString("serviceType"));
        contract.setQuantityServices(rs.getInt("quantityService"));
        contract.setUnitsOfMeasure(rs.getInt("unitsOfMeasure"));
        contract.setPriceUnit(rs.getDouble("priceUnit"));
        contract.setCifCompany(rs.getString("cifCompany"));
        return contract;
    }
}
