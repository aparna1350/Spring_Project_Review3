package com.example.demobook.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demobook.Service.BookService;
import com.example.demobook.model.Book;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class BookController {
	@Autowired
	  BookService bookService;
	@Tag(name="Get",description="get data")
	  @GetMapping(value="/fetchBook")
	  public List<Book> getAllEmployee()
	  {
		  List<Book> bookList=bookService.getAllBook();
		  return bookList;
	  }
	@Tag(name="Post",description="post data")
	  @PostMapping(value="/saveBook")
	  public Book saveEmployee(@RequestBody Book b)
	  {
	 	 return bookService.saveBook(b);
	  }
	@Tag(name="Put",description="put data")
	  @PutMapping(value="/updateBook")
	  public Book updateStudent(@RequestBody Book b)
	  {
	 	 return bookService.saveBook(b);
	  }
	@Tag(name="Delete",description="delete data")
	  @DeleteMapping("/deleteBook/{bno}")
	 	 public void deleteStudent(@PathVariable("bno") int bookNo)
	 	 {
	 		 bookService.deleteBook(bookNo);
	 	 }
	 @GetMapping(value="/getBook/{bno}")
	 public Book getBook(@PathVariable("bno") int bookNo)
	 {
	 	return bookService.getBook(bookNo);
	 }
	 
	 //sorting
	 //ascending
	 @GetMapping("/sortBooks/{field}")
	 public List<Book>sortBooks(@PathVariable String field)
	 {
	 	return bookService.sortBooks(field); 
	 }

	 ///pagination

//	      http://localhost:8080/pageStudents/0/1

	 @GetMapping("/pagingBooks/{offset}/{pageSize}")
	 public List<Book> pagingBooks(@PathVariable int offset,@PathVariable int pageSize)
	 {
	 	return bookService.pagingBooks(offset,pageSize);
	 }


	 //pagination and sorting

	 @GetMapping("/pagingAndSortingBooks/{offset}/{pageSize}/{field}")
	 public List<Book> pagingAndSortingBooks(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	 {
	 	return bookService.pagingAndSortingBooks(offset,pageSize,field);
	 }


}
