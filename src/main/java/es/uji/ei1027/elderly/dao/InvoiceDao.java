package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Add Invoice
    public void addInvoice(Invoice invoice) {
        jdbcTemplate.update("INSERT INTO invoice VALUES(?, ?, ?, ?, ?)", invoice.getDate(), invoice.getNumber(), invoice.getAmount(),
                invoice.getConcept(), invoice.getDniElderly());
    }

    //Delete elderly from db
    public void deleteInvoice(int number) {
        jdbcTemplate.update("DELETE FROM invoice WHERE number = ?", number);
    }

    //Update invoice
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update("UPDATE invoice SET date=?, number=?, amount=?, concept=?, dniElderly=? WHERE number=?", invoice.getDate(),
                invoice.getNumber(), invoice.getAmount(), invoice.getConcept(), invoice.getDniElderly(), invoice.getNumber());
    }

    //Obtener invoice por el numero
    public Invoice getInvoiceByNumber(int number) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM invoice WHERE number=?", new InvoiceRowMapper(), number);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //Obtener invoices de un elderly
    public List<Invoice> getInvoicesByElderly(String dniElderly) {
        try {
            return jdbcTemplate.query("SELECT * FROM invoice WHERE dniElderly=?", new InvoiceRowMapper(), dniElderly);
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<Invoice>();
        }
    }

    //Listado de invoices
    public List<Invoice> getInvoices() {
        try {
            return jdbcTemplate.query("SELECT * FROM invoice", new InvoiceRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<Invoice>();
        }
    }
}
