package org.yosa.fakebaseapi.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yosa.fakebaseapi.payload.NewsRequest;
import org.yosa.fakebaseapi.payload.NewsResponse;
import org.yosa.fakebasecore.domain.News;
import org.yosa.fakebasecore.domain.Type;
import org.yosa.fakebasecore.services.NewsService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ModelMapper modelMapper;

    private static Logger logger = LoggerFactory.getLogger(NewsController.class);

    @GetMapping("")
    public List<NewsResponse> getAll(@RequestParam(value = "page", defaultValue = "0") int page){
        List<News> news = newsService.getAll(page).getContent();
        logger.info("Returning all news");
        return modelMapper.map(news, new TypeToken<List<NewsResponse>>(){}.getType());
    }

    @GetMapping("{id}")
    public NewsResponse getOne(@PathVariable String id){
        News news = newsService.getById(id);
        logger.info("Returning news with id = " + id);
        return modelMapper.map(news, NewsResponse.class);
    }

    @GetMapping("/search")
    public List<NewsResponse> search(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam("query") String query){
        List<News> news = newsService.search(query, page).getContent();
        logger.info("Searching news with query = " + query);
        return modelMapper.map(news, new TypeToken<List<NewsResponse>>(){}.getType());
    }

    @PostMapping("")
    public NewsResponse createNew(@RequestBody NewsRequest newsRequest){
        News createdNews = newsService.create(new News(newsRequest.getTitle(),
                newsRequest.getText(),
                new Date(),
                Type.valueOf(newsRequest.getType())));
        logger.info("Created news with id = " + createdNews.getId());
        return modelMapper.map(createdNews, NewsResponse.class);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        newsService.delete(id);
        logger.info("Deleted news with id = " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
