package com.pcfegress.springboot.basics.pcfegress;

//import java.io.File;
//import java.io.InputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurlConnection {
	String url;
	
	public CurlConnection(String url) {
		super();
		this.url = url;
	}	
	
	public String getURL() {
		return url;
	}

	@Override
	public String toString() {
		return "CurlConnection [url=" + url  + "]";
	}
	
	public String getCurlConnection(int commChoice) throws InterruptedException {
		String[] command1 = {"curl", "-x", "webproxy.merck.com:8080", url};
		String[] command2 = {"curl", "-v", url};
		String[] command3 = {"curl", "-I", url};
		String[] command4 = {"curl", "-k", url};
		
		ProcessBuilder process = null;
			
		if (commChoice == 1) {
			process = new ProcessBuilder(command1);
		}else if (commChoice == 2) {
			process = new ProcessBuilder(command2);
		}else if (commChoice == 3){
			process = new ProcessBuilder(command3);
		}else {
			process = new ProcessBuilder(command4);
		}
			
		Process p;
		String result = null;
		long res = 0;
		
		try {
			p = process.start();		
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
				System.out.println(line);
			}
			result = builder.toString();
			System.out.print(result);
			p.destroy();
			Thread.sleep(1000);
			res = p.exitValue();
			if (res != 0) {
				result = "The curl command failed with exit value: " + res;	
			}		
		} catch (IOException e) {
			System.out.print("Process start error:");
			e.printStackTrace();
		}
		
		return result;
	}
}
