package org.share.topic.impl.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.share.topic.api.dao.ITopicDao;
import org.share.topic.api.domain.ITopicService;
import org.share.topic.api.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TopicService implements ITopicService {
	@Autowired
	private ITopicDao topicDao;

	@Override
	public PageInfo<Topic> queryTopics() {
		PageHelper.startPage(1, 10);
		Map<String,Object> params = new HashMap<String,Object>();
		List<Topic> topics = topicDao.queryTopics(params);
		PageInfo<Topic> result = new PageInfo<Topic>(topics);
		return result;
	}

}
