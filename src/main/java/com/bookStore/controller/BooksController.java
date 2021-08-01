package com.bookStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.model.Book;
import com.bookStore.service.BookStoreService;

@RestController

public class BooksController {
	
	@Autowired
	BookStoreService bookStoreService;
	
	@GetMapping(path="/", produces= {"application/json"})
	public ResponseEntity<List<Book>> getBooksData()
	{
		return new ResponseEntity<List<Book>> (bookStoreService.getBooksDetails(), HttpStatus.CREATED);
		
	}
	@GetMapping(path="/{bookId}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable("bookId") Integer bookId)
	{
		return new ResponseEntity<Optional<Book>> (bookStoreService.getBookByID(bookId), HttpStatus.OK); 
	}
	@GetMapping(path="/search/{titleTerm}")
	public ResponseEntity<List<Book>> getBookById(@PathVariable("titleTerm") String titleTerm)
	{
		return new ResponseEntity<List<Book>> ( bookStoreService.searchBookByTitleKey(titleTerm), HttpStatus.OK);
	}
	

}
