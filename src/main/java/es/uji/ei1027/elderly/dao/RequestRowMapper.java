package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Request;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public final class RequestRowMapper implements RowMapper<Request> {
    @Override
    public Request mapRow(ResultSet rs, int i) throws SQLException {
        Request request = new Request();
        request.setNumber(rs.getInt("number"));
        request.setServiceType(rs.getString("serviceType"));
        request.setCreationDate(rs.getObject("creationDate", LocalDate.class));
        request.setState(rs.getString("state"));
        request.setApprovedDate(rs.getObject("approvedDate", LocalDate.class));
        request.setRejectedDate(rs.getObject("rejectedDate", LocalDate.class));
        request.setComments(rs.getString("comments"));
        request.setEndDate(rs.getObject("endDate", LocalDate.class));
        request.setDniElderly(rs.getString("dniElderly"));
        request.setNumberContract(rs.getInt("numberContract"));
        return request;
    }
}
