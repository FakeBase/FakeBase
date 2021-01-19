package org.yosa.fakebasecore.repositories.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.yosa.fakebasecore.domain.es.NewsEs;

import java.util.List;

public interface NewsEsRepository extends ElasticsearchRepository<NewsEs, String> {
    Page<NewsEs> findByTitleAndText(String title, String text, Pageable pageable);
    Page<NewsEs> findByTitleAndTextContaining(String title, String text, Pageable pageable);
}
