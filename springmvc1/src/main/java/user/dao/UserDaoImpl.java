package user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import user.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> listUser() throws Exception {
		System.out.println("listUser 호출됨!!!");
		return null;
	}

	@Override
	public User getUser(int id) throws Exception {
		System.out.println("getUser 호출됨!!!" + id);
		return null;
	}

	@Override
	public int insertUser(User user) throws Exception {
		System.out.println("insertUser 호출됨!!!");
		return 0;
	}

	@Override
	public int updateUser(User user) throws Exception {
		System.out.println("updateUser 호출됨!!!");
		return 0;
	}

	@Override
	public int deleteUser(int id) throws Exception {
		System.out.println("deleteUser 호출됨!!!");
		return 0;
	}

}