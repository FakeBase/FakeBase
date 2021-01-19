package org.yosa.fakebasecore.services;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yosa.fakebasecore.domain.News;
import org.yosa.fakebasecore.exceptions.NewsNotFoundException;
import org.yosa.fakebasecore.repositories.NewsRepository;

import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;


    public News getById(String id){
        return newsRepository.findById(id)
                .orElseThrow(() -> new NewsNotFoundException("News not found."));
    }

    public Page<News> getAll(int page){
        return newsRepository.findAll(
                PageRequest.of(page, 50, Sort.by(Sort.Direction.DESC, "id")));
    }
}
