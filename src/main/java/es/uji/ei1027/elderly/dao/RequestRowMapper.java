package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Request;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class RequestRowMapper implements RowMapper<Request> {
    @Override
    public Request mapRow(ResultSet rs, int i) throws SQLException {
        Request request = new Request();
        request.setNumber(rs.getInt("number"));
        request.setServiceType(rs.getString("serviceType"));
        request.setCreationDate(rs.getDate("creationDate"));
        request.setState(rs.getString("state"));
        request.setApprovedDate(rs.getDate("approvedDate"));
        request.setRejectedDate(rs.getDate("rejectedDate"));
        request.setComments(rs.getString("comments"));
        request.setEndDate(rs.getDate("endDate"));
        request.setDniElderly(rs.getString("dniElderly"));
        request.setNumberContract(rs.getInt("numberContract"));
        return request;
    }
}
