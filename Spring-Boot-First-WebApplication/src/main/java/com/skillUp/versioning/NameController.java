package com.skillUp.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class NameController {
@GetMapping("V1/name")
	public nameV1 getNameV1() {
		
		return new nameV1("prathap");
	}

@GetMapping("V2/name")
public nameV2 getNameV2() {
	
	return new nameV2("prathap", "ch");
}
}
