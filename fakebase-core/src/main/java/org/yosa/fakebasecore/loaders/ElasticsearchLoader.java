package org.yosa.fakebasecore.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yosa.fakebasecore.domain.es.NewsEs;
import org.yosa.fakebasecore.repositories.AccountRepository;
import org.yosa.fakebasecore.repositories.NewsRepository;
import org.yosa.fakebasecore.repositories.es.NewsEsRepository;

import javax.annotation.PostConstruct;

@Component
public class ElasticsearchLoader {

    @Autowired
    private NewsEsRepository newsEsRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostConstruct
    @Transactional
    public void loadAll() {
        elasticsearchTemplate.indexOps(NewsEs.class).create();
        newsRepository.findAll().forEach(news -> {
            newsEsRepository.save(new NewsEs(news.getTitle(), news.getText(), news.getDate(), news.getType()));
        });
    }
}
