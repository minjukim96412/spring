package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.UserDao;
import user.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> listUser() throws Exception {
		return userDao.listUser();
	}

	@Override
	public User getUser(int id) throws Exception {
		return userDao.getUser(id);
	}

	@Override
	public int insertUser(User user) throws Exception {
		return userDao.insertUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) throws Exception {
		return userDao.deleteUser(id);
	}

}
