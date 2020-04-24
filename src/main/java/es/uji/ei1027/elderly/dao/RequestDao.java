package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Add request
    public void addRequest(Request request) {
        jdbcTemplate.update("INSERT INTO request VALUES(?, ?, ?,? ?, ?, ?, ?, ?)", request.getNumber(), request.getServiceType(), request.getCreationDate(),
                request.getState(), request.getApprovedDate(), request.getRejectedDate(), request.getComments(), request.getEndDate(), request.getDniElderly(),
                request.getNumberContract());
    }
    //Update
    public void updateRequest(Request request) {
        jdbcTemplate.update("UPDATE request SET number = ?, serviceType = ?, creationDate = ?, state = ?, approvedDate = ?, rejectedDate = ?, " +
                "comments = ?, endDate = ?, dniElderly = ?, numberContract = ? WHERE number = ?", request.getNumber(), request.getServiceType(), request.getCreationDate(),
                request.getState(), request.getApprovedDate(), request.getRejectedDate(), request.getComments(), request.getEndDate(), request.getDniElderly(),
                request.getNumberContract(), request.getNumber());
    }

    //Delete
    public void deleteRequest(int number) {
        jdbcTemplate.update("DELETE FROM request WHERE number = ?", number);
    }

    //Obtener request de un elderly
    public List<Request> getRequestsByElderly(String dniElderly) {
        try {
            return jdbcTemplate.query("SELECT * FROM request WHERE dniElderly = ?", new RequestRowMapper(), dniElderly);
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<Request>();
        }
    }

    //Obtener request
    public Request getRequestByNumber(int number) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM request WHERE number = ?", new RequestRowMapper(), number);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //List
    public List<Request> getRequests() {
        try {
            return jdbcTemplate.query("SELECT * FROM request", new RequestRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<Request>();
        }
    }
}
