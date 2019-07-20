package org.share.topic.impl.controller;

import java.util.List;
import org.share.topic.api.domain.IArticleService;
import org.share.topic.api.model.article.ArticleCustomVVO;
import org.share.topic.api.model.article.BaseVO;
import org.share.topic.api.model.article.ClassficationBaseVO;
import org.share.topic.api.model.article.ClassficationCustomVVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class ArticleController {
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private IArticleService articleService;
	
	@PostMapping("/save")
	public String saveArticle(@RequestBody BaseVO baseVo) throws Exception {
		articleService.save(baseVo);
		return "success";
	}
	
	@GetMapping("/articles")
	public List<ClassficationCustomVVO> saveArticle() {
		List<ClassficationCustomVVO> vvos = null;
		try {
			vvos = articleService.queryArticles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vvos;
	}
	
	@GetMapping("/classfications")
	public List<ClassficationBaseVO> selectClassfication() {
		List<ClassficationBaseVO> vvos = null;
		try {
			vvos = articleService.selectClassfication();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vvos;
	}
	
	@GetMapping("detail/{articleId}")
	public ArticleCustomVVO showDetail(@PathVariable Long articleId) throws Exception {
		System.err.println(articleId);
		return articleService.showDetail(articleId);
	}
}
