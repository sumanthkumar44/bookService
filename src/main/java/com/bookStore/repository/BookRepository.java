package com.bookStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByTitleContainingIgnoreCase(String titleTerm);
	
	

}
