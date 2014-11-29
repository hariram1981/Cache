package com.hariram.cache;

import org.apache.log4j.Logger;

/**
 * Manages cache by adding and retrieving objects from cache
 * 
 * @author hariram
 * date 29-Oct-2014
 */
public final class CacheManager {
	
	private static final Logger LOGGER = Logger.getLogger(CacheManager.class);
	
	/**
	 * Default constructor (made private as utility class).
	 */
	private CacheManager() {
	}
	
	/**
	 * Adds the value to the key in cache.
	 * 
	 * @param key - key to be used to store in the cache
	 * @param value - value that is stored in the cache for the particular key
	 * @param cacheRefresh sub-class of CacheRefresh that overrides refresh() for refreshing mechanism
	 */
	public static void addToCache(Object key, Object value, CacheRefresh cacheRefresh) {
		LOGGER.info("CacheManager.addToCache(): add key (" + key + "), value (" + value + "), cacheRefresh ("+ cacheRefresh + ")");
		Cache.getInstance().setCacheRefresh(cacheRefresh);
		Cache.getInstance().put(key, value);
	}
	
	/**
	 * Get object for the particular key from cache.
	 * 
	 * @param key - key whose value is to be fetched from cache
	 * @return Object value of the key in cache
	 */
	public static Object getFromCache(Object key) {
		Object value = Cache.getInstance().getValue(key);
		LOGGER.info("CacheManager.getFromCache(): get key (" + key + "), value (" + value + ")");
		return value;
	}
	
	/**
	 * Return refresh duration in seconds.
	 * 
	 * @return long refresh duration of cache
	 */
	public static long getRefreshDuration() {
		long refreshDuration = Cache.getInstance().getRefreshDuration();
		LOGGER.info("CacheManager.getRefreshDuration(): refreshDuration (" + refreshDuration + ")");
		return refreshDuration;
	}

	/**
	 * Sets the refresh duration in seconds.
	 * 
	 * @param refreshDuration - refresh duration in seconds
	 */
	public static void setRefreshDuration(long refreshDuration) {
		LOGGER.info("CacheManager.setRefreshDuration(): refreshDuration (" + refreshDuration + ")");
		Cache.getInstance().setRefreshDuration(refreshDuration);
	}
}
