package org.share.topic.impl.domain;

import java.util.List;
import org.share.topic.api.dao.IUserDao;
import org.share.topic.api.domain.IUserService;
import org.share.topic.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> findUsers() {
		PageHelper.startPage(1, 2);
		return userDao.findUsers();
	}
	
}
