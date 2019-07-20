package org.share.topic.impl.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.share.topic.api.dao.IArticleDao;
import org.share.topic.api.domain.IArticleService;
import org.share.topic.api.model.article.ArticleCustomVVO;
import org.share.topic.api.model.article.ArticleDTO;
import org.share.topic.api.model.article.ArticleDetailDTO;
import org.share.topic.api.model.article.BaseVO;
import org.share.topic.api.model.article.ClassficationBaseVO;
import org.share.topic.api.model.article.ClassficationCustomVVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class ArticleService implements IArticleService{
	
	@Autowired
	private IArticleDao articleDao;
	
	@Transactional
	@Override
	public int save(BaseVO baseVo) throws Exception {
		String title = baseVo.getTitle();
		String content = baseVo.getContent();
		Long classId = baseVo.getClassId();
		if(null == classId){
			throw new Exception("请选择博客类型");
		}
		if(StringUtils.isEmpty(title)){
			throw new Exception("博客标题不能为空");
		}
		if(StringUtils.isEmpty(content)){
			throw new Exception("博客内容不能为空");
		}
		ArticleDTO articleDto = new ArticleDTO(classId, title);
		int count = articleDao.saveArticle(articleDto);
		if(count > 0) {
			ArticleDetailDTO articleDetailDto = new ArticleDetailDTO(articleDto.getArticleId(), content);
			count = articleDao.saveArticleDetail(articleDetailDto);
		}
		return count;
	}

	@Override
	public List<ClassficationCustomVVO> queryArticles() throws Exception {
		List<ClassficationCustomVVO> customs = new ArrayList<ClassficationCustomVVO>();
		
		List<ClassficationBaseVO> classfications = articleDao.queryClassfications();
		for(ClassficationBaseVO vvo : classfications) {
			ArticleDTO dto = new ArticleDTO();
			dto.setClassId(vvo.getClassId());
			List<ArticleCustomVVO> articles = articleDao.queryArticles(dto);

			ClassficationCustomVVO custom = new ClassficationCustomVVO();
			custom.setClassId(vvo.getClassId());
			custom.setName(vvo.getName());
			if(CollectionUtils.isNotEmpty(articles)) {
				custom.setArticles(articles);
			}
			customs.add(custom);
		}
		return customs;
	}

	@Override
	public List<ClassficationBaseVO> selectClassfication() throws Exception {
		return articleDao.queryClassfications();
	}

	@Override
	public ArticleCustomVVO showDetail(Long articleId) throws Exception {
		return articleDao.showDetail(articleId);
	}

}
