package com.hariram.cache;

import org.apache.log4j.Logger;

/**
 * Cache refresh class that has criteria for refreshing the cache.
 * refresh() can be overridden for specific refreshing
 * 
 * @author hariram
 *
 */
public class CacheRefresh {

	private static final Logger LOGGER = Logger.getLogger(CacheManager.class);

	/**
	 * Refreshes the cache
	 */
	public void refresh() {
		LOGGER.debug("CacheRefresh.refresh(): refreshes the cache");
		System.out.println("in super method of refresh");
	}
}
