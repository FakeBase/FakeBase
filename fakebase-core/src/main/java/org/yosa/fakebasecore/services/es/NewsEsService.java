package org.yosa.fakebasecore.services.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yosa.fakebasecore.domain.es.NewsEs;
import org.yosa.fakebasecore.repositories.es.NewsEsRepository;

import java.util.List;

@Service
public class NewsEsService {
    @Autowired
    private NewsEsRepository newsEsRepository;

    public Page<NewsEs> searchNews(String data, int page){
        return newsEsRepository.findByTitleAndTextContaining(data, data,
                PageRequest.of(page, 50, Sort.by(Sort.Direction.DESC, "id")));
    }

    public void addNewsIndex(NewsEs newsEs){
        newsEsRepository.save(newsEs);
    }

    public void addNewsIndexBulk(List<NewsEs> newsEs){
        newsEsRepository.saveAll(newsEs);
    }
}
