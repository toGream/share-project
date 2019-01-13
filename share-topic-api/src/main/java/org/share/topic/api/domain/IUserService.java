package org.share.topic.api.domain;

import org.share.topic.api.model.User;
import com.github.pagehelper.PageInfo;

public interface IUserService {
	public PageInfo<User> findUsers();
}
