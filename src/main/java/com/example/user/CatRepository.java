package com.example.user;

import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Category, Integer> {
}
