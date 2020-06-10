package com.codegym.repositories;

import com.codegym.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
