package org.share.topic.impl.domain;

import java.util.List;
import org.share.topic.api.dao.IUserDao;
import org.share.topic.api.domain.IUserService;
import org.share.topic.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public PageInfo<User> findUsers() {
		PageHelper.startPage(1, 10);
		List<User> users = userDao.findUsers();
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		return pageInfo;
	}
	
}
