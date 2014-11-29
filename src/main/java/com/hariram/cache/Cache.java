package com.hariram.cache;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Class that caches data objects in a map
 * 
 * @author hariram
 * date 29-Oct-2014
 */
class Cache {
	public static final Cache CACHE = new Cache();
	// Object that refreshes the cache
	private CacheRefresh cacheRefresh;
	// Map that is the cache
	private static final Map<Object, Object> map = new HashMap<>();
	// Refresh duration in seconds - 1 hour = 60 * 60 = 3600 seconds
	private long refreshDuration = 3600;
	// Last refreshed time
	private LocalTime lastRefreshedTime = null;

	private static final Logger LOGGER = Logger.getLogger(Cache.class);

	/**
	 * Default Constructor - made private as utility class
	 */
	private Cache() {
	}

	/**
	 * Returns the single instance of the class
	 * 
	 * @return cache object
	 */
	public static Cache getInstance() {
		return CACHE;
	}

	/**
	 * Returns the object in the map based on input key
	 * 
	 * @param key
	 *            - key to put in cache map
	 * @return object for the particular key
	 */
	public Object getValue(Object key) {
		if (refreshCache()) {
			cacheRefresh.refresh();
		} 
		return map.get(key);
	}

	/**
	 * Puts the object to the key provided in the cache map
	 * 
	 * @param key
	 *            - key to put in cache map
	 * @param value
	 *            - object for the key
	 */
	public void put(Object key, Object value) {
		map.put(key, value);
		lastRefreshedTime = LocalTime.now();
	}
	
	/**
	 * Refreshes the Cache as per the cache duration set
	 * 
	 * @return true or false if cache is expired or not
	 */
	private boolean refreshCache() {
		if (lastRefreshedTime == null) {
			lastRefreshedTime = LocalTime.now();
			return false;
		}

		if (lastRefreshedTime.plusSeconds(refreshDuration).isAfter(
				LocalTime.now())) {
			return false;
		} else {
			// Cache expired hence refresh it
			lastRefreshedTime = LocalTime.now();
			return true;
		}
	}

	/**
	 * Returns Refresh duration for cache
	 * 
	 * @return refresh duration
	 */
	public long getRefreshDuration() {
		return refreshDuration;
	}

	/**
	 * Sets refresh duration for cache
	 * 
	 * @param refreshDuration
	 */
	public void setRefreshDuration(long refreshDuration) {
		this.refreshDuration = refreshDuration;
	}

	/**
	 * Returns cache refresh object that handles what
	 * to happen when cache is refreshed
	 * 
	 * @return cache refresh object
	 */
	public CacheRefresh getCacheRefresh() {
		return cacheRefresh;
	}

	/**
	 * Sets refresh cache
	 * 
	 * @param cacheRefresh
	 */
	public void setCacheRefresh(CacheRefresh cacheRefresh) {
		this.cacheRefresh = cacheRefresh;
	}
}
