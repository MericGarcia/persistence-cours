package fr.keyconsulting.formation.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import fr.keyconsulting.formation.persistence.JDBCPersistenceService;
import fr.keyconsulting.formation.service.PersistenceService;

public class DataBaseHandler {
	
	private String driverClassName;
	private String dbURL;
	private static DataBaseHandler instanceUnique;
	private Connection connection;
	private Logger log;
	
	/**
	 * Retourne de l'instance unique.
	 */
	public final static synchronized DataBaseHandler getInstance() {
		if (instanceUnique == null) {
			instanceUnique = new DataBaseHandler();
		}
		return instanceUnique;
	}

	/**
	 * Constructeur (singleton).
	 */
	protected DataBaseHandler() {
		this.connection = null;
		this.driverClassName = null;
		this.dbURL = null;
		this.log = Logger.getLogger(this.getClass());
	}

	public void init(String driver, String url) throws ClassNotFoundException {
		Class.forName(driver);
		this.driverClassName = driver;
		this.dbURL = url;
	}
	
	public void connect(String user, String password) throws SQLException {
		connection = DriverManager.getConnection(dbURL, user, password);
		if (connection == null) {
			throw new SQLException("Impossible d'obtenir une connexion");
		}
	}

	public void commit() throws SQLException {
		connection.commit();
		connection.setAutoCommit(true);
	}

	public void rollback() throws SQLException {
		connection.rollback();
	}

	public void disconnect() throws SQLException {
		if (this.connection != null) {
			commit();
			this.connection.close();
			this.connection = null;
		} 
	}
	
    public Connection getConnection() {
        return this.connection;
    }


}
