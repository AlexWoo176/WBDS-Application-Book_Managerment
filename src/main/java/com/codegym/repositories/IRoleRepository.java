package com.codegym.repositories;

import com.codegym.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
