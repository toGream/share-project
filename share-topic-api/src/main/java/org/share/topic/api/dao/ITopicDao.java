package org.share.topic.api.dao;

import java.util.List;
import java.util.Map;
import org.share.topic.api.model.Topic;

public interface ITopicDao {
	public List<Topic> queryTopics(Map<String,Object> params);
}
