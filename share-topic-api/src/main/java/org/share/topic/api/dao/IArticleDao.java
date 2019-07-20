package org.share.topic.api.dao;

import java.util.List;

import org.share.topic.api.model.article.ArticleCustomVVO;
import org.share.topic.api.model.article.ArticleDTO;
import org.share.topic.api.model.article.ArticleDetailDTO;
import org.share.topic.api.model.article.ClassficationBaseVO;
import org.share.topic.api.model.article.ClassficationCustomVVO;

public interface IArticleDao {
	
	public int saveArticle(ArticleDTO articleDto);
	
	public int saveArticleDetail(ArticleDetailDTO articleDetailDto);

	public List<ClassficationBaseVO> queryClassfications();
	
	public List<ArticleCustomVVO> queryArticles(ArticleDTO dto);
	
	public ArticleCustomVVO showDetail(Long articleId);
	
}
