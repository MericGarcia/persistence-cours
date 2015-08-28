package fr.keyconsulting.formation.persistence;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import fr.keyconsulting.formation.model.Calcul;
import fr.keyconsulting.formation.persistence.database.DBUtils;
import fr.keyconsulting.formation.persistence.database.DataBaseHandler;
import fr.keyconsulting.formation.service.PersistenceService;

public class MyORMPersistenceService implements PersistenceService {

	private static final String PASSWORD = "test";
	private static final String USER = "test";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/testJDBC";

	private static final String INSERT = "insert into :table (:columns) VALUES (:values)";
	private static final String SELECT = "select * from :table";

	
	private DataBaseHandler dbHandler;

	public MyORMPersistenceService() {
		dbHandler = DataBaseHandler.getInstance();
		try {
			dbHandler.init(DRIVER, URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void persist(Calcul calcul) {
		try {
			dbHandler.connect(USER, PASSWORD);
			insertQuery(calcul);
			dbHandler.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbHandler.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void insertQuery(Calcul calcul) throws SQLException {
		PreparedStatement statement = null;
		String sql = null;

		/*
		 * 
		 * Create sql query using reflection tools
		 * 
		 * */

		statement = dbHandler.getConnection().prepareStatement(sql);
		
		/*
		 * 
		 * update prepared statement using reflection tools
		 * 
		 * */	

		statement.executeUpdate();
	}

	private List<Calcul> selectAllQuery(String table) throws SQLException {
		List<Calcul> calculs = new ArrayList<>();
		Statement stmt = null;

		String query = null;

		
		/*
		 * 
		 * Create sql query using reflection tools
		 * 
		 * */
		
		stmt = dbHandler.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			Calcul calcul = new Calcul();
			/*
			 * 
			 * Update calcul object using reflection tool
			 * 
			 * */
			calculs.add(calcul);
		}
		
		return calculs;
	}

	@Override
	public List<Calcul> load() {
		List<Calcul> result = Collections.emptyList();
		try {
			dbHandler.connect(USER, PASSWORD);
			result = selectAllQuery(Calcul.class.getSimpleName());
			dbHandler.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbHandler.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
