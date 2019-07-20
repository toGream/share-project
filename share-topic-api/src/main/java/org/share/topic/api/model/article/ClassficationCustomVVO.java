package org.share.topic.api.model.article;

import java.util.List;

public class ClassficationCustomVVO extends ClassficationBaseVO{
	private List<ArticleCustomVVO> articles;
	
	public List<ArticleCustomVVO> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleCustomVVO> articles) {
		this.articles = articles;
	}
}
