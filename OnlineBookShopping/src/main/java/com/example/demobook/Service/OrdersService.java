package com.example.demobook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demobook.Repository.OrdersRepository;
import com.example.demobook.model.Orders;

import jakarta.transaction.Transactional;


@Service
public class OrdersService {
	@Autowired
	OrdersRepository bookRepository;
	public List<Orders>getAllBook()
	{
		List<Orders> bookList=bookRepository.findAll();
		return bookList;
	}
	public Orders savePersons(Orders p)
	{
		return bookRepository.save(p);
	}
	public Orders updateStudent(Orders s)
	 {
        Orders obj=bookRepository.save(s);
		 return obj;
	 }
	 
	 //deleteMapping
	 
	 public void deleteStudent(Long id)
	 {
		 bookRepository.deleteById(id);
	 }
	public List<Orders> getOrdersByOrderTrackingNumber(String orderNo, String status) 
	{
		return bookRepository.getOrdersByOrderTrackingNumber(orderNo, status);
	}
	
	@Transactional
	
	public int deleteOrdersBystatus(String status) {
	return bookRepository.deleteOrdersBystatus(status);
	}
	@Transactional

	 public int update(String username,String userid)

	 {

		 return bookRepository.UpdateOrdersByStatus(username,userid);

	 }
	//native
	public List<Orders> getOrdersByStatus(String status)
	{
		return bookRepository.getOrdersByStatus(status);
	}
}
