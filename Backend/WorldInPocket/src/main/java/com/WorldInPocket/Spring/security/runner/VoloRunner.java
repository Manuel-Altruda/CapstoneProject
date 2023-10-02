//package com.WorldInPocket.Spring.security.runner;
//
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import com.WorldInPocket.Spring.security.service.VoloService;
//
//@Component
//public class VoloRunner implements ApplicationRunner {
//
//	private final VoloService voloService;
//	
//	public VoloRunner (VoloService voloService) {
//		this.voloService = voloService;
//	}
//	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		voloService.generateAndInsertRandomFlights(30);
//		
//	}
//	
//	
//}
