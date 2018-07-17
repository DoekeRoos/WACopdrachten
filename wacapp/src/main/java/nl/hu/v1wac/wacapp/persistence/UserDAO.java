package nl.hu.v1wac.wacapp.persistence;

public interface UserDAO {
	public String findRoleForUser(String name, String pass);
}
