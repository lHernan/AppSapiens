package com.mdsql.bussiness.service.impl;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.MDSQLConstants;
import com.mdsql.utils.DateFormatter;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public class ServiceSupport {
	
	protected DateFormatter dateFormatter;
	
	protected DateFormatter oracleDateFormatter;
	
	private ConfigurationSingleton configuration;
	
	@SneakyThrows
	public ServiceSupport() {
		dateFormatter = new DateFormatter();
		oracleDateFormatter = new DateFormatter(MDSQLConstants.ORACLE_OBJECT_DATE_FORMAT_FOR_PROCEDURES);
		configuration = ConfigurationSingleton.getInstance();
	}
	
	/**
	 * @param array
	 * @return
	 * @throws SQLException
	 */
	protected ServiceException buildException(Array array) throws SQLException {
		return buildException((Object[]) array.getArray(), MDSQLConstants.ERROR);
	}
	
	/**
	 * @param array
	 * @return
	 * @throws SQLException
	 */
	protected ServiceException buildWarning(Array array) throws SQLException {
		return buildException((Object[]) array.getArray(), MDSQLConstants.WARN);
	}
	
	/**
	 * @param array
	 * @return
	 * @throws SQLException
	 */
	protected ServiceException buildException(Object[] array, String type) throws SQLException {
		ServiceException exception = new ServiceException(type);
		
		List<Object[]> errors = new ArrayList<>();
		for (Object row : array) {
			Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
			errors.add(cols);
		}
		
		exception.setErrors(errors);
		return exception;
	}
	
	/**
	 * @param runSP
	 * @param objects
	 */
	protected void logProcedure(String runSP, Object... objects) {
		LogWrapper.debug(log, "%s", runSP);
		
		if (!Objects.isNull(objects)) {
			StringBuilder sbArgumentos = new StringBuilder("Parámetros de entrada: \n");
			for (Object o : objects) {
				String value = (!Objects.isNull(o) && !StringUtils.isBlank(o.toString())) ? o.toString() : "NULL";
				sbArgumentos.append("\t").append(value).append("\n");
			}
			LogWrapper.debug(log, "%s", sbArgumentos.toString().trim());
		}
	}
	
	/**
	 * @param procedure
	 * @param callFormat
	 * @return
	 */
	@SneakyThrows
	protected String createCall(String procedure, String callFormat) {
		String proc = configuration.getConfig(procedure);
		String paquete = configuration.getConfig(MDSQLConstants.PAQUETE);
		String llamada = String.format(MDSQLConstants.FORMATO_LLAMADA, paquete, proc).toUpperCase();
		return String.format(callFormat, llamada);
	}
	
	/**
	 * @return
	 */
	@SneakyThrows
	protected String createCallTypeError() {
		String paquete = configuration.getConfig(MDSQLConstants.PAQUETE);
		return String.format(MDSQLConstants.FORMATO_LLAMADA, paquete, MDSQLConstants.T_T_ERROR).toUpperCase();
	}
	
	/**
	 * @return
	 */
	@SneakyThrows
	protected String createCallType(String type) {
		String paquete = configuration.getConfig(MDSQLConstants.PAQUETE);
		return String.format(MDSQLConstants.FORMATO_LLAMADA, paquete, type).toUpperCase();
	}
}
