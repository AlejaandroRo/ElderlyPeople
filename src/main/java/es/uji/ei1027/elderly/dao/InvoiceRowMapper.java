package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Contract;
import es.uji.ei1027.elderly.model.Invoice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public final class InvoiceRowMapper implements RowMapper<Invoice> {
    public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setDate(rs.getObject("date", LocalDate.class));
        invoice.setNumber(rs.getInt("number"));
        invoice.setAmount(rs.getInt("amount"));
        invoice.setConcept(rs.getString("concept"));
        invoice.setDniElderly(rs.getString("dniElderly"));
        return invoice;
    }
}
