package com.codegym.services;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T model);

    void remove(Long id);
}
