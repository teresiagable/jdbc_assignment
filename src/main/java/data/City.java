package data;

public class City {
	  private int ID;
	  private String Name;
	  private String CountryCode;
	  private String District;
	  private int Population;
	  
	public City(int iD, String name, String countryCode, String district, int population) {
		ID = iD;
		Name = name;
		CountryCode = countryCode;
		District = district;
		Population = population;
	}

//	public City(ResultSet rs) {
//
//		try {
//			rs.first();
//			this.ID = rs.getInt("ID");
//			this.Name = rs.getString("Name");
//			this.CountryCode = rs.getString("CountryCode");
//			this.District = rs.getString("District");
//			this.Population = rs.getInt("Population");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	public int getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	}

	@Override
	public String toString() {
		return "City [ID=" + ID + ", Name=" + Name + ", CountryCode=" + CountryCode + ", District=" + District
				+ ", Population=" + Population + "]";
	}
	
	


}
