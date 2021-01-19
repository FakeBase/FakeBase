package org.yosa.fakebasecore.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yosa.fakebasecore.domain.News;

public interface NewsRepository extends MongoRepository<News, String> {
}
