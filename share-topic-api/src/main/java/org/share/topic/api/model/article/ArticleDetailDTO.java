package org.share.topic.api.model.article;

public class ArticleDetailDTO {
	private Long articleDetailId;
	private Long articleId;
	private String content;
	
	public ArticleDetailDTO(Long articleId, String content) {
		this.articleId = articleId;
		this.content = content;
	}
	
	public Long getArticleDetailId() {
		return articleDetailId;
	}
	public void setArticleDetailId(Long articleDetailId) {
		this.articleDetailId = articleDetailId;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
