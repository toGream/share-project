package org.share.topic.api.domain;

import java.util.List;
import org.share.topic.api.model.User;

public interface IUserService {
	public List<User> findUsers();
}
