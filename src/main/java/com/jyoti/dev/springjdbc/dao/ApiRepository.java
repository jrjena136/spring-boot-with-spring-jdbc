package com.jyoti.dev.springjdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.jyoti.dev.springjdbc.model.ApiModel;
import com.jyoti.dev.springjdbc.model.CustomerInfo;

import oracle.jdbc.OracleTypes;

@Repository
public class ApiRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource datasource;

	// thanks Java 8, look the custom RowMapper
	public List<ApiModel> findAll() {
		System.out.println("Datasource : " + datasource);
		List<ApiModel> result = jdbcTemplate.query(
				"SELECT APINAME, VERSION, ADMIN_ADDRESS, ADMIN_NAME, PLATFORM FROM APIMANAGEMENT1 where rownum<=10",
				(rs, rowNum) -> new ApiModel(rs.getString("APINAME"), rs.getString("VERSION"),
						rs.getString("ADMIN_ADDRESS"), rs.getString("ADMIN_NAME"), rs.getString("PLATFORM")));

		return result;

	}

	public Map<String, Object> doCustomerRegistration(CustomerInfo customerInfo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("CUSTOMER_REGISTRATION").
				declareParameters(
						new SqlParameter("P_MSISDN", OracleTypes.VARCHAR),
						new SqlParameter("P_LOB", OracleTypes.VARCHAR),
						new SqlParameter("P_CIRCLE", OracleTypes.VARCHAR),
						new SqlParameter("P_CHANNEL", OracleTypes.VARCHAR),
						new SqlParameter("P_USER_TYPE", OracleTypes.VARCHAR),
						new SqlOutParameter("P_STATUS", OracleTypes.VARCHAR));
		Map<String,String> in = new HashMap<String,String>();
		in.put("P_MSISDN", customerInfo.getMsisdn());
		in.put("P_LOB", customerInfo.getLob());
		in.put("P_CIRCLE", customerInfo.getCircle());
		in.put("P_CHANNEL", customerInfo.getChannel());
		in.put("P_USER_TYPE", customerInfo.getUserType());
		/*in.put("P_MSISDN","1234567899");
		in.put("P_LOB","Test");
		in.put("P_CIRCLE","Test");
		in.put("P_CHANNEL","Test");
		in.put("P_USER_TYPE","Test");*/
		Map<String,Object> execute = simpleJdbcCall.execute(new MapSqlParameterSource(in));
		
		System.out.println("Proc Res : " + execute);
		return execute;
	}

}
