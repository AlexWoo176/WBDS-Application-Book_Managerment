package com.codegym.repositories;

import com.codegym.models.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
