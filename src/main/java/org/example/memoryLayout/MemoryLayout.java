package org.example.memoryLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openjdk.jol.info.ClassLayout;

public class MemoryLayout {

	public static void main(String[] args) {
//		System.out.println(VM.current().details());
//		System.out.println(ClassLayout.parseClass(ArrayList.class).toPrintable());
//		System.out.println(ClassLayout.parseClass(SimpleLong.class).toPrintable());
		List<String> list =new ArrayList<>();
//		System.out.println(ClassLayout.parseInstance(list).toPrintable());
		list.add("one");
//		System.out.println(ClassLayout.parseInstance(list).toPrintable());
//		System.out.println(ClassLayout.parseInstance(new HashMap<>()).toPrintable());
		System.out.println(ClassLayout.parseClass(HashMap.class).toPrintable());


	}

}
 class SimpleLong {
	 private long state;
    private int id;
}
