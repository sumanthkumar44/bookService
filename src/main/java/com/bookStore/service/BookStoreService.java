package com.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookStore.exception.BookException;
import com.bookStore.model.Book;
import com.bookStore.repository.BookRepository;

@Service
	public class BookStoreService{
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	BookRepository bookRepository;

	public List<Book> getBooksDetails()
	{
		HttpHeaders header = new HttpHeaders();
		String resource ="https://s3-ap-southeast-1.amazonaws.com/he-public-data/books8f8fe52.json";
		ResponseEntity< List<Book>> bookListRes
					= restTemplate.exchange(resource, HttpMethod.GET,null,new ParameterizedTypeReference<List<Book>>() {
					} );
		List<Book> bookList = bookListRes.getBody();
		try{
		bookRepository.saveAll(bookList);
		}
		catch(Exception e)
		{
			throw new BookException(603, "Exception while fetching and saving books");
		}
		
		return bookList;
	}

	public Optional<Book> getBookByID(Integer bookId) {
		// TODO Auto-generated method stub
		Optional<Book> book= bookRepository.findById(bookId);
		if(book.get()!=null)
		{
			return book;
		}
		else
		{
			throw new BookException(601, "Book with ID "+bookId+" not found");
		}
			
	}

	public List<Book> searchBookByTitleKey(String titleTerm) {
		// TODO Auto-generated method stub
		 List<Book> books= bookRepository.findByTitleContainingIgnoreCase(titleTerm);
		if((books!=null && books.size()>0) || !books.isEmpty())
		{
			return books;
		}
		else
		{
			throw new BookException(602, "Could not find any book that contains title "+ titleTerm);
		}
	}

}
