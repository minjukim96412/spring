package user.dao;

import java.util.List;

import user.domain.User;

public interface UserDao {

	public abstract List<User> listUser() throws Exception;

	public abstract User getUser(int id) throws Exception;

	public abstract int insertUser(User user) throws Exception;

	public abstract int updateUser(User user) throws Exception;

	public abstract int deleteUser(int id) throws Exception;

}