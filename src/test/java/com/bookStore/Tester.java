package com.bookStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Tester {
	public static Logger logger =  LoggerFactory.getLogger(SpringRunner.class);
	
	@Test
	public void hello()
	{
		assertEquals(true,true);
	}
}

