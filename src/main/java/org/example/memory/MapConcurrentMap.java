package org.example.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapConcurrentMap {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("a", "a");
		Map<String, String> cMap = new ConcurrentHashMap<String, String>();
		System.out.println(map + " :: " + cMap);
		cMap.put("a", "a");
	}

}
