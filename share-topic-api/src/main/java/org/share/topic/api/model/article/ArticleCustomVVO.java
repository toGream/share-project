package org.share.topic.api.model.article;

import java.util.Date;

public class ArticleCustomVVO{
	private Long articleId;
	private String title;
	private Date creationDate;
	private Date lastUpdateDate;
	private Long pollCount;
	private Long commentCount;
	private Long classId;
	private Short isEssence; 
	private Short isTop;
	private String content;
	
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public Long getPollCount() {
		return pollCount;
	}
	public void setPollCount(Long pollCount) {
		this.pollCount = pollCount;
	}
	public Long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Short getIsEssence() {
		return isEssence;
	}
	public void setIsEssence(Short isEssence) {
		this.isEssence = isEssence;
	}
	public Short getIsTop() {
		return isTop;
	}
	public void setIsTop(Short isTop) {
		this.isTop = isTop;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
