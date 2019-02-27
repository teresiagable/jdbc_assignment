package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CityDaoImpl implements CityDao {
	public void printCities() {

		try {
			Connection connection = Database.getConnection();

			Statement statement = connection.createStatement();
			String findAllCities = "SELECT name FROM city";
			ResultSet rs = statement.executeQuery(findAllCities);

			while (rs.next()) {
				System.out.println("City: " + rs.getString(1) + " ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private PreparedStatement createPreparedStatement(Connection conn, int number) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE ID = ?");
		statement.setInt(1, number);
		return statement;
	}
	
	private PreparedStatement createPreparedStatement(Connection conn, String code) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE countrycode LIKE  ?");
		statement.setString(1,  "%" + code + "%");
		return statement;
	}
	
	private PreparedStatement createNamePreparedStatement(Connection conn, String name) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE name LIKE  ?");
		statement.setString(1, "%" +  name + "%");
		return statement;
	}
	
	private PreparedStatement createInsertStatement(Connection conn, City theCity) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("INSERT INTO city (Name, CountryCode, District, Population) VALUES (?,?,?,?)");
		statement.setString(1, theCity.getName());
		statement.setString(2,  theCity.getCountryCode());
		statement.setString(3, theCity.getDistrict());
		statement.setInt(4, theCity.getPopulation());
		
		return statement;
	}
	
	private PreparedStatement createUpdateStatement(Connection conn, City theCity) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("UPDATE city SET Name=?, CountryCode=?, District=?, Population=? WHERE ID=?");
		statement.setString(1, theCity.getName());
		statement.setString(2,  theCity.getCountryCode());
		statement.setString(3, theCity.getDistrict());
		statement.setInt(4, theCity.getPopulation());
		statement.setInt(5, theCity.getID());
		
		return statement;
	}
	
	private City createCityFromResultSet(ResultSet rs) throws SQLException{
		return new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
	}
	
	@Override
	public City findById(int id) {
		City theCity = null;		
		try(Connection connection =  Database.getConnection();
				PreparedStatement statement = createPreparedStatement(connection, id);
				ResultSet rs = statement.executeQuery()){			

			while(rs.next()) {
				theCity =  createCityFromResultSet(rs);
			}		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return theCity;
	}

	@Override
	public List<City> findByCode(String code) {
		List<City> theCities = new ArrayList<City>();
		try (Connection connection = Database.getConnection();

			PreparedStatement preStatement = createPreparedStatement(connection,code);
			ResultSet rs = preStatement.executeQuery())
		{
		
			while (rs.next()) {
				theCities.add(createCityFromResultSet(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theCities;
	}
	
	@Override
	public List<City> findByName(String name) {
		List<City> theCities = new ArrayList<City>();
		try (Connection connection = Database.getConnection();
				PreparedStatement preStatement = createNamePreparedStatement(connection, name);
				ResultSet rs = preStatement.executeQuery();) {
			while (rs.next()) {
				theCities.add(createCityFromResultSet(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theCities;
	}
	
	@Override
	public List<City> findAll() {
		List<City> theCities = new ArrayList<City>();
		try (
			Connection connection = Database.getConnection();
			PreparedStatement preStatement = connection.prepareStatement("SELECT * FROM city ");			 
			ResultSet rs = preStatement.executeQuery();)
		{
			while(rs.next()) {
				theCities.add(createCityFromResultSet(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theCities;
	}
	
	public void printCitiesFirstVersion() {

		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;

		try {

			connection = Database.getConnection();

			statement = connection.createStatement();
			String findAllCities = "SELECT name FROM city";
			rs = statement.executeQuery(findAllCities);

			while (rs.next()) {
				System.out.println("City: " + rs.getString(1) + " ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {

					rs.close();

				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public City add(City city) {
		
		try (Connection connection = Database.getConnection();
				PreparedStatement statement = createInsertStatement(connection, city);) {
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	@Override
	public City update(City city) {
		try (Connection connection = Database.getConnection();
				PreparedStatement statement = createUpdateStatement(connection, city);) {
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	@Override
	public int delete(City city) {
		// TODO Auto-generated method stub
		return 0;
	}






}
