package com.cg.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.cg.entity.Cart;
import com.cg.service.CartService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService service;

	public CartController(CartService service) {
		this.service = service;
	}

	@PostMapping("/{cartId}")
	public Cart addProduct(@PathVariable Long cartId, @RequestBody Long pid) {

		return service.addProduct(cartId, pid);
	}

	@GetMapping("/{id}")
	@CircuitBreaker(name = "cartService", fallbackMethod = "fallbackgetCart")
	public Map<String, Object> getCart(@PathVariable Long id) {
		return service.getCart(id);
	}
	
	
	public Map<String, Object> fallbackgetCart(@PathVariable Long id,Exception e) {
		Map<String, Object> m = new HashMap<>();
	    m.put("products", new ArrayList<>());
	    m.put("recommendations", new ArrayList<>());
	    m.put("message", "Cart service is currently unavailable. Please try again later.");
	    return m;
	}
}
