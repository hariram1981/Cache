Cache
=====

- Project that can be used to cache data in hashmap

- Cache can be used to either just store data in hashmap and retrieving (without any refreshing mechanism) or we can implement our own refreshing mechanism. It is apt wherein static data has to be stored for a period of time.

Classes
----------
###1. com.hariram.cache.CacheManager
 - Utility class to manage functionalities for caching (internally caching is achieved through com.hariram.cache.Cache class which has access specifier as package and hence not accessible outside this package).

####static void addToCache(Object key, Object value, CacheRefresh cacheRefresh)
 - Adds the key and value to the cache. 
 - cacheRefresh is a class which can be extended and passed as argument to this function; it is used to refresh the cache. If we have our own way of refreshing the cache, then that can be provided through a sub class of CacheRefresh and passed as argument to this method.
 
####static Object getFromCache(Object key)
 - Fetches the value for the key from the cache.
 
####static long getRefreshDuration()
 - Returns the refresh duration that has been set. This determines as to how often the cache has to be refreshed.
 - Default refresh that is implemented in CacheRefresh will do nothing and hence we have to write our own sub-class overriding refresh() method so that refreshing will use the logic provided.
 
####static void setRefreshDuration(long refreshDuration)
 - Sets the refresh duration for the cache.
 - Every refreshDuration, the cache will be refreshed.
 
###2. com.hariram.CacheRefresh
 - Class that can be extended to write our own implementation of refreshing of the cache.
 
####void refresh()
 - Refreshes the cache. 
 - Logic for refreshing has to be provided in our sub-class to this class and in this method overriden.
 - Default implementation does nothing.
 
Usage
----------
- Usage can be checked in the JUnit test case that has been written for it but below is a sample:

		String key = "a";
		String value = "value";
		CacheManager.addToCache(key, value, new CacheRefresh());
		
		Object valueFromCache = CacheManager.getFromCache(key);

- In above, CacheManager.addToCache sets the value "value" to the key "a". And getFromCache(key) fetches the value "value".

License
==========
Copyright (c) 2014 GitHub, Inc. See the LICENSE file for license rights and limitations (GNU GPL v2.0)

