package org.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Test2 {

	public static void main(String[] args) {
		int nThreads = 10;
		ExecutorService ser = Executors.newFixedThreadPool(nThreads);
		List<Future<Long>> list = new ArrayList<>();
		IdProviderImpl impl = new IdProviderImpl();
		IntStream.range(0, nThreads).forEach(e -> {
			list.add(ser.submit(impl::getQniqueID));
		});
		ser.shutdown();
		list.stream().forEach(e -> {
			try {
				System.out.println(e.get());
			} catch (InterruptedException | ExecutionException e1) {
				e1.printStackTrace();
			}
		});

	}

}

interface Idprovider {
	long getQniqueID();
}

class IdProviderImpl implements Idprovider {

	AtomicLong al = new AtomicLong();

	@Override
	public long getQniqueID() {
		return al.incrementAndGet();
	}

}