package org.example.generics;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Snippet {

	static Map<String, Object> map = new HashMap<>();

	public static <T> void set(String id, T value) {
		map.put(id, value);
	}

	public static Collection<?> getGen(String id) {
		return (Collection<?>) map.get(id);
	}

	public static void main(String[] args) {
			ArrayList<Object> value = new ArrayList<>();
			set("1", value);
			set("2", new HashSet<>());
			System.out.println(getGen("2"));
	}
}
