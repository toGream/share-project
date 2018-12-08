package org.share.topic.api.dao;

import java.util.List;

import org.share.topic.api.model.User;

public interface IUserDao {
	public List<User> findUsers();
}
