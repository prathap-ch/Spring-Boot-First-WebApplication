package com.skillUp.controllers;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.skillUp.beans.FilterBean;
@RestController
public class FilterController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveFilterBean() {
		FilterBean filterBean = new FilterBean("field1", "filed2", "filed3");
		SimpleBeanPropertyFilter sbf=SimpleBeanPropertyFilter.filterOutAllExcept("field1,filed2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("someFilterBean", sbf);
		MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(filterBean);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	@GetMapping("/filter")
	public FilterBean retrieveFilter() {
		FilterBean fb = new FilterBean("field1", "filed2", "filed3");
		SimpleBeanPropertyFilter sbf=SimpleBeanPropertyFilter.filterOutAllExcept("field1,filed2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("someFilterBean", sbf);
		MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(fb);
		mappingJacksonValue.setFilters(filters);
		return fb;
	}
}
