package org.share.topic.api.domain;

import java.util.Map;
import org.share.topic.api.model.Topic;

import com.github.pagehelper.PageInfo;

public interface ITopicService {
	public PageInfo<Topic> queryTopics();
}
