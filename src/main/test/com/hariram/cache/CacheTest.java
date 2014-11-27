package com.hariram.cache;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CacheTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String key = "a";
		String value = "value";
		CacheManager.addToCache(key, value, new CacheRefresh());
		
		Object valueFromCache = CacheManager.getFromCache(key);
		System.out.println(valueFromCache);
		if(valueFromCache == null) {
			fail("Failure");
		} else {
			assertTrue("successful", true);
		}
	}
	
	@Test
	public void testRefresh() {
		String key = "a";
		String value = "value";
		CacheManager.setRefreshDuration(2);
		CacheManager.addToCache(key, value, new MyCacheRefresh());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object valueFromCache = CacheManager.getFromCache(key);
		System.out.println(valueFromCache);
		if(valueFromCache == null) {
			fail("Failure");
		} else {
			assertTrue("successful", true);
		}
	}

}
