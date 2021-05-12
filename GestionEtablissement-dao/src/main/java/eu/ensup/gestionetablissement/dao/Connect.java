package eu.ensup.gestionetablissement.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The type Connect.
 */
public class Connect
{




	/**
	 * Open an connention with the information in the class
	 *
	 * @return an connection open
	 */
	public static Connection openConnection() throws ExceptionDao
	{
		Properties prop = new Properties();

		{
			try {
				prop = load(); } catch (IOException e) { }
		}
		String driver = prop.getProperty("db.driver");
		String url = prop.getProperty("db.url");
		String username = prop.getProperty("db.username");
		String password = prop.getProperty("db.password");

		Connection cn = null;
		try
		{
			//Chargement du Driver
			Class.forName(driver);
			//?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC
			
			//Récuperation de la connection
			if( url != null && username != null && password != null )
				cn = DriverManager.getConnection(url, username, password);
			
			if( cn == null && url != null )
				cn = DriverManager.getConnection(url);

			// TODO:  Add logger failed and successfull
		}
		catch (ClassNotFoundException | SQLException e){
			// TODO:  Add logger failed and successfull
			throw new ExceptionDao("Nous ne parvenons pas à joindre le serveur distant. Veuillez réessayer ultérieurement");
		}
		
		return cn;
	}

	public static Properties load() throws IOException, FileNotFoundException, IOException {
		try (
			InputStream input = new FileInputStream("GestionEtablissement-dao/target/classes/db.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("db.url"));
			System.out.println(prop.getProperty("db.user"));
			System.out.println(prop.getProperty("db.password"));
			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
