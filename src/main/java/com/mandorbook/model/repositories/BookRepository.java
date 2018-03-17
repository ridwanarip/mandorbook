package com.mandorbook.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mandorbook.model.Book;

/**
 * 
 * @author ridwan
 *
 */

public interface BookRepository extends CrudRepository<Book, Long>{

}