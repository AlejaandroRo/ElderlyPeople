package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

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

}
