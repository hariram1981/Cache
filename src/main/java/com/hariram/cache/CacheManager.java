package com.hariram.cache;

import org.apache.log4j.Logger;

/**
 * Manages cache by adding and retrieving objects from cache
 * 
 * @author hariram
 * @date 29-10-2014
 */
public final class CacheManager {
	
	private static final Logger LOGGER = Logger.getLogger(CacheManager.class);
	
	/**
	 * Default constructor (made private as utility class).
	 */
	private CacheManager() {
	}
	
	/**
	 * Adds particular DAO (its method) to the cache.
	 * 
	 * @param className
	 * @param methodName
	 */
	public static void addToCache(Object key, Object value, CacheRefresh cacheRefresh) {
		LOGGER.info("CacheManager.addToCache(): add key (" + key + "), value (" + value + "), cacheRefresh ("+ cacheRefresh + ")");
		Cache.getInstance().setCacheRefresh(cacheRefresh);
		Cache.getInstance().put(key, value);
	}
	
	/**
	 * Get array of cacheobject from cache.
	 * 
	 * @param className
	 * @param methodName
	 * @return
	 */
	public static Object getFromCache(Object key) {
		Object value = Cache.getInstance().getValue(key);
		LOGGER.info("CacheManager.getFromCache(): get key (" + key + "), value (" + value + ")");
		return value;
	}
	
	/**
	 * Return refresh duration in seconds.
	 * 
	 * @return
	 */
	public static long getRefreshDuration() {
		long refreshDuration = Cache.getInstance().getRefreshDuration();
		LOGGER.info("CacheManager.getRefreshDuration(): refreshDuration (" + refreshDuration + ")");
		return refreshDuration;
	}

	/**
	 * Sets the refresh duration in seconds.
	 * 
	 * @param refreshDuration
	 */
	public static void setRefreshDuration(long refreshDuration) {
		LOGGER.info("CacheManager.setRefreshDuration(): refreshDuration (" + refreshDuration + ")");
		Cache.getInstance().setRefreshDuration(refreshDuration);
	}
}
