package com.aws;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class MicroserviceAwsCodePipelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAwsCodePipelineApplication.class, args);
	}

	@Autowired
	private OrderDao orderDao;

	@GetMapping
	public List<Order> fetchOrders() {
		return orderDao.getOrders().stream().sorted(Comparator.comparing(Order::getName)).collect(Collectors.toList());
	}
}
