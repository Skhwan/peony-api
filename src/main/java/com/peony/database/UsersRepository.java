package com.peony.database;

import com.peony.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByUsername(String username);
    Users findByUsernameAndPassword(String username, String password);
}
