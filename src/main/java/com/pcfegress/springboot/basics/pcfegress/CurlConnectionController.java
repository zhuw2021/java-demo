package com.pcfegress.springboot.basics.pcfegress;


//import java.util.Arrays;
//import java.util.List;
//import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurlConnectionController {	
	@GetMapping("/")
	public String getUsage(){
		
		String usage1 = "/curl-v?url=";
		String usage2 = "/curl-I?url=";
		String usage3 = "/curl-x?url=";
		String usage4 = "/curl-k?url=";
		
		String usage = "<br><h1>" + usage1 + "<br>" + usage2 + "<br>" + usage3 + "<br>" + usage4+  "</h1>";
		
		return usage;
	}
	
	@GetMapping(path = "/curl-x")
	@ResponseBody
	//public String getCurlConnPathVar(@PathVariable String url) {
	public String getCurlConnParamProxy(@RequestParam String url) throws InterruptedException {
		//System.out.println("url:"+ "https://" + url);
		CurlConnection curlConnection = new CurlConnection(url);
		String result = curlConnection.getCurlConnection(1);
	
		return result;
	}
	@GetMapping(path = "/curl-v")
	public String getCurlConnParamWithV(@RequestParam String url) throws InterruptedException {
		//System.out.println("url:"+ "https://" + url);
		CurlConnection curlConnection = new CurlConnection(url);
		String result = curlConnection.getCurlConnection(2);
	
		return result;
	}
	
	@GetMapping(path = "/curl-I")
	public String getCurlConnParamWithI(@RequestParam String url) throws InterruptedException {
		//System.out.println("url:"+ "https://" + url);
		CurlConnection curlConnection = new CurlConnection(url);
		String result = curlConnection.getCurlConnection(3);
	
		return result;
	}
	
	@GetMapping(path = "/curl-k")
	public String getCurlConnParamWithK(@RequestParam String url) throws InterruptedException {
		//System.out.println("url:"+ "https://" + url);
		CurlConnection curlConnection = new CurlConnection(url);
		String result = curlConnection.getCurlConnection(4);
	
		return result;
	}
}
