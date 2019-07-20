package org.share.topic.api.model.article;

import java.util.Date;

public class ArticleDTO {
	private Long articleId;
	private String title;
	private Long userId;
	private Date creationDate;
	private Date lastUpdateDate;
	private Long pollCount;
	private Long commentCount;
	private Long classId;
	private Short isEssence;
	private Short isTop;
	private String validFlag;
	
	public ArticleDTO() {
		
	}
	
	public ArticleDTO(Long classId, String title) {
		this.title = title;
		this.creationDate = new Date();
		this.lastUpdateDate = this.creationDate;
		this.userId = -1l;
		this.pollCount = 0l;
		this.commentCount = 0l;
		this.isEssence = 0;
		this.isTop = 0;
		this.validFlag = "1";
		this.classId = classId;
	}
	
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
}
