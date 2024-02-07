package com.mulloa.demobci.Service;

import static org.junit.Assert.*;

import org.junit.Test;

import io.jsonwebtoken.lang.Assert;

public class UserServiceTest {

	/*
	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}
	*/

	/*
	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}
	*/

	@Test
	public void testValidaEmailTrue() {
		UserService userService = new UserService(null, null, null, null, null);
		boolean result = userService.validaEmail("yugo147@gmail.com");
		
		assertNotNull(result);
		assertEquals(true, result);
	}

	@Test
	public void testValidaEmailFalse() {
		UserService userService = new UserService(null, null, null, null, null);
		boolean resultFalse = userService.validaEmail("yugo147gmail.com");
		
		assertNotNull(resultFalse);
		assertEquals(false, resultFalse);
	}
	
	/*
	@Test
	public void testExisteUser() {
		fail("Not yet implemented");
	}
	*/
	
	/*
	@Test
	public void testUserService() {
		fail("Not yet implemented");
	}
	*/

}
