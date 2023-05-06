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

import com.example.demobook.Service.OrdersService;
import com.example.demobook.model.Orders;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
public class OrdersController {
	@Autowired
	  OrdersService bookService;
	@Tag(name="Get",description="get data")
	  @GetMapping(value="/fetchOrders")
	  public List<Orders> getAllEmployee()
	  {
		  List<Orders> bookList=bookService.getAllBook();
		  return bookList;
	  }
	@Tag(name="Post",description="post data")
	  @PostMapping("/saveOrders")
	  public Orders savePersons(@RequestBody Orders p)
	  {
	  	return bookService.savePersons(p);
	  }
	@PutMapping(value="/updateStudent")
	 public Orders updateStudent(@RequestBody Orders s)
	 {
		 return bookService.updateStudent(s);
	 }
	 
	 
	 @DeleteMapping("/deleteStudent/{id}")
		 public void deleteStudent(@PathVariable("id") Long id)
		 {
			 bookService.deleteStudent(id);
		 }
	//Jpa Query
	@Tag(name="Get",description="get data")
	  @GetMapping("/fetchOrdersByOrderTrackingNumber/{orderNo}/{status}")
		 public List<Orders>fetchgetOrdersByOrderTrackingNumber(@PathVariable String orderNo,@PathVariable String status)
		 {
			 return bookService.getOrdersByOrderTrackingNumber(orderNo,status);
		 }
	@Tag(name="Delete",description="delete data")
		 @DeleteMapping("/deleteOrdersByStatus/{status}")
		 public String deleteOrdersByStatus(@PathVariable String status)
		 {
		 int result=bookService.deleteOrdersBystatus(status);
		 if(result >0)
		 	return "Order record deleted";
		 else
		 	return "Problem occured while deleting";
		 }

			//DML queries
	@Tag(name="Put",description="put data")
			@PutMapping("/update/{orderTrackingNumber}/{status}")

			public String update(@PathVariable String orderTrackingNumber,@PathVariable String status)

			{

				int result=bookService.update(orderTrackingNumber,status);

				if(result>0)

					return "Updated Successfully";

				else

					return "Problem occur while updating";

			}
	//NATIVE QUERY
	@GetMapping("/getByServing/{status}")
  	public List<Orders> getOrdersByStatus(@PathVariable String status)
  	{
  		return bookService.getOrdersByStatus(status);
  	}
}
