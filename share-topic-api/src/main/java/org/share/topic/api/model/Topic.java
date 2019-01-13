package org.share.topic.api.model;

import java.util.Date;

public class Topic {
	private Long topicId;
	private Integer topicType;
	private String topicTitle;
	private String topicContent;
	private String topicLink;
	private String topicAuthor;
	private Date creationDate;
	
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public Integer getTopicType() {
		return topicType;
	}
	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public String getTopicLink() {
		return topicLink;
	}
	public void setTopicLink(String topicLink) {
		this.topicLink = topicLink;
	}
	public String getTopicAuthor() {
		return topicAuthor;
	}
	public void setTopicAuthor(String topicAuthor) {
		this.topicAuthor = topicAuthor;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
