package org.yosa.fakebasecore.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yosa.fakebasecore.domain.Account;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByUsername(String username);
}
