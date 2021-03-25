package pl.poznan.put.cie.coffee;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CoffeeDao {

	private final NamedParameterJdbcTemplate jdbc;

	public CoffeeDao() {
		// TODO init jdbc using pl.poznan.put.cie.coffee.DbUtilities
		//this.jdbc = null;
                 this.jdbc = new NamedParameterJdbcTemplate(DbUtilities.getDataSource("jdbc:derby://localhost:1527/coffe_sql"));
		//throw new UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Returns a coffee with given name.
	 *
	 * @param name coffee name
	 * @return coffee object or null
	 */

       public Coffee get(final String name) {
		String sql = "SELECT sup_id, price, sales, total FROM coffees "
				  + "WHERE cof_name = :cof_name ";
		MapSqlParameterSource params = new MapSqlParameterSource("cof_name", name);
		return jdbc.query(sql, params, new ResultSetExtractor<Coffee>() {

                   
			@Override
			public Coffee extractData(ResultSet rs) throws SQLException, DataAccessException {
                            
                     rs.next();
                     return new Coffee(
                                        name,
                                        rs.getInt("sup_id"), 
                                        new BigDecimal(rs.getFloat("price")), 
                                        rs.getInt("sales"), 
                                        rs.getInt("total"));
                                
                       // throw new UnsupportedOperationException("no coffee name in the database");
			}
		});
	}

	/**
	 * Returns a list of all coffees.
	 *
	 * @return list of all coffees
	 */
	public List<Coffee> getAll() {
           
            String sql = "SELECT cof_name, sup_id, price, sales, total FROM coffees";
		try {
          	// TODO invoke NamedParameterJdbcTemplate.query(String, RowMapper<T>)
                       return jdbc.query(sql, new RowMapper<Coffee>() {
                       
                            @Override
                            public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
                                Coffee coffe = new Coffee();
                                coffe.setName(rs.getString("cof_name"));
                                coffe.setSupplierId(rs.getInt("sup_id"));
                                coffe.setPrice(new BigDecimal(rs.getFloat("price")));
                                coffe.setSales(rs.getInt("sales"));
                                coffe.setTotal(rs.getInt("total"));
                                return coffe;
                                
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
                               
			//throw new UnsupportedOperationException("Not implemented yet.");
		} catch (EmptyResultDataAccessException ex) {
			return new ArrayList<>();
		}
	}

	public void update(Coffee c) {

		String sql = "UPDATE coffees "
				  + "SET price = :price, sales = :sales, total = :total "
				  + "WHERE cof_name = :cof_name AND sup_id = :sup_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("price", c.getPrice());
		parameters.put("sales", c.getSales());
		parameters.put("total", c.getTotal());
		parameters.put("cof_name", c.getName());
		parameters.put("sup_id", c.getSupplierId());
		jdbc.update(sql, parameters);
	}

	public void delete(String name, int supplierId) {
		// TODO implement method CoffeeDao#delete(), use NamedParameterJdbcTemplate.update(String, Map)
		//DELETE FROM coffees WHERE cof_name = ? AND sup_id = ?
                String sql = "DELETE FROM coffees WHERE cof_name = :cof_name AND sup_id = :sup_id";
                
                Map<String, Object> parameters = new HashMap<>();
		parameters.put("cof_name", name);
		parameters.put("sup_id", supplierId);
		jdbc.update(sql, parameters);
		//throw new UnsupportedOperationException("Not implemented yet.");
	}

        
        /*  create table COFFEES
                        (COF_NAME varchar(32) NOT NULL,
                        SUP_ID int NOT NULL,
                        PRICE numeric(10,2) NOT NULL,
                        SALES integer NOT NULL,
                        TOTAL integer NOT NULL,
                        PRIMARY KEY (COF_NAME),
                        FOREIGN KEY (SUP_ID) REFERENCES SUPPLIERS (SUP_ID));*/ 
	public void create(Coffee c) {
		// TODO implement method CoffeeDao#create(), use NamedParameterJdbcTemplate.update(String, Map)
		// INSERT INTO coffees(cof_name, sup_id, price, sales, total) VALUES(?, ?, ?, ?, ?)
		String sql = "INSERT INTO coffees(cof_name, sup_id, price, sales, total) "
                        + "VALUES(:cof_name, :sup_id, :price, :sales, :total)";

                Map<String, Object> parameters = new HashMap<>();
		parameters.put("cof_name", c.getName());
		parameters.put("sup_id", c.getSupplierId());
                parameters.put("price", c.getPrice());
                parameters.put("sales", c.getSales());
                parameters.put("total", c.getTotal());
                
		jdbc.update(sql, parameters);
          //  throw new UnsupportedOperationException("Not implemented yet.");
	}

}
