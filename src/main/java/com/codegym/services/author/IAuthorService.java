package com.codegym.services.author;

import com.codegym.models.Author;
import com.codegym.services.IService;

import java.util.Optional;

public interface IAuthorService extends IService<Author> {
    Iterable<Author> findAll();

    Optional<Author> findById(Long id);

    void save(Author author);

    void remove(Long id);
}
