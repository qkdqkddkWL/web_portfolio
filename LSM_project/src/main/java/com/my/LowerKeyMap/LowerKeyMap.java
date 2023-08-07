package com.my.LowerKeyMap;

import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.commons.lang.StringUtils;

public class LowerKeyMap extends ListOrderedMap {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Object put(Object key,Object value) {
		
		return super.put(StringUtils.lowerCase((String) key), value);
	}
	
}
