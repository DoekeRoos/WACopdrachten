package nl.hu.v1wac.wacapp.persistence;

import java.sql.*;

public class UserPostgresDAOImpl extends PostgresBaseDAO{
	public String findRoleForUser(String username, String pass) {
		String role = null;
		Connection con = super.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT role FROM useraccount WHERE username = '" 
											+ username + "' AND password = '" + pass + "'");
			
			if(rs.next())
				role = rs.getString("role");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return role;
	}
}
