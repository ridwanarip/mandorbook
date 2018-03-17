package com.mandorbook.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mandorbook.model.Author;

/**
 * 
 * @author ridwan
 *
 */

public interface AuthorRepository extends CrudRepository<Author, Long>{

}