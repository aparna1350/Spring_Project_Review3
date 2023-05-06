package com.example.demobook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demobook.Repository.BookRepository;
import com.example.demobook.model.Book;


@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	public List<Book>getAllBook()
	{
		List<Book> bookList=bookRepository.findAll();
		return bookList;
	}
	public Book saveBook(Book b)
	{
		 Book obj=bookRepository.save(b);
		 return obj;
		 //return studRepository.save(s);
	}
	public Book updateBook(Book b)
	{
		 Book obj=bookRepository.save(b);
		 return obj;
		 //return studRepository.save(s);
	}
	public void deleteBook(int bookNo)
	{
		 bookRepository.deleteById(bookNo);
	}
	public Book getBook(int bookNo)
	{
		 Book b=bookRepository.findById(bookNo).get();
		 return b;
	}
	
	
	 // sorting//
	 
	 public List<Book> sortBooks(String field)
	 {
		 //ascending
		 return bookRepository.findAll(Sort.by(field));
		 //descending findAll(Sort.by(Direction,field))
		 //return bookRepository.findAll(Sort.by(Direction.DESC, field));
	 }
	 
	 //pagination
	 
	 public List<Book> pagingBooks(int offset,int pageSize)
	 {
		 Pageable paging=PageRequest.of(offset,pageSize);
		 Page<Book> studData=bookRepository.findAll(paging);
		 List<Book>bookList=studData.getContent();
		 return bookList;
	 }
	 
	 
	 //pagination and sorting
	 
	 public List<Book> pagingAndSortingBooks(int offset,int pageSize,String field) 
	 {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
		Page<Book> stud=bookRepository.findAll(paging);
		return stud.getContent();
	 }
	 
	
	    	
}
