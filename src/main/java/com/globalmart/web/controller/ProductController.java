package com.globalmart.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.dao.ProductDao;
import com.globalmart.model.ProductCatalogue;

@RestController
@RequestMapping("/productCatalogue")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, headers="Accept=application/json")
	public List<ProductCatalogue> getAllProducts(Model model) {

		logger.debug("In Controller get All products");

		return productDao.findAll();

	}
	
	@RequestMapping(value = "/addProducts", method = RequestMethod.POST, headers="Accept=application/json")
	public void addProducts(@RequestBody ProductCatalogue product) {

		logger.debug("In Controller add Products");

		productDao.add(product);

	}
	
	@ResponseBody @RequestMapping(value = "/removeProducts/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
	public void addProducts(@PathVariable("id") String productId) {

		logger.debug("In Controller remove Products");

		productDao.remove(productId);

	}


}