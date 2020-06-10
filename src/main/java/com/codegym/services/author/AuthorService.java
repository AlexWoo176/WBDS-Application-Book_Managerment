package com.codegym.services.author;

import com.codegym.models.Author;
import com.codegym.repositories.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(authorRepository.findOne(id));
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void remove(Long id) {
        authorRepository.delete(id);
    }
}
