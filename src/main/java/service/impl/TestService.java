package service.impl;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {
	public String Hello() {
		return "Hello World.";
	}
}
