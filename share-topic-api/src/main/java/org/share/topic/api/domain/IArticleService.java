package org.share.topic.api.domain;

import java.util.List;

import org.share.topic.api.model.article.ArticleCustomVVO;
import org.share.topic.api.model.article.BaseVO;
import org.share.topic.api.model.article.ClassficationBaseVO;
import org.share.topic.api.model.article.ClassficationCustomVVO;

public interface IArticleService {
	public int save(BaseVO baseVo)throws Exception;
	
	public List<ClassficationCustomVVO> queryArticles()throws Exception;
	
	public List<ClassficationBaseVO> selectClassfication()throws Exception;
	
	public ArticleCustomVVO showDetail(Long articleId)throws Exception;
}
