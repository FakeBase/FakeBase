package org.yosa.fakebasecore.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yosa.fakebasecore.domain.News;

import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {
    @Query("{'$or' : [{\"title\" : {\"$regex\" : ?0 }, \"text\" : {\"$regex\" : ?0 }}] }")
    Page<News> search(@Param("query") String query, Pageable pageable);
}
