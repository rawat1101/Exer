package org.example.threads;

public class ThreadPrintEvenOdd {
	static class Resource implements Runnable {
		int c = 0;
		Object lock = new Object();

		@Override
		public void run() {
			synchronized (lock) {
				/*if (c % 2 == 0) {
					System.out.println("even");
					c++;
				} else {
					System.out.println("odd");
					c++;
				}*/

				while (c < 15) {
					if (Thread.currentThread().getName().equals("e")) {
						if (c % 2 == 0) {
							System.out.println(c++);
							lock.notify();
						} else
							try {
								lock.wait();
							} catch (InterruptedException e) {
								System.out.println("InterruptedException ::even");
							}

					} else if (c % 2 != 0) {
						System.out.println(c++);
						lock.notify();
					} else
						try {
							lock.wait();
						} catch (InterruptedException e) {
							System.out.println("InterruptedException ::odd");

						}
				}

			}

		}
	}

	public static void main(String[] args) {
		Runnable r = new Resource();
		Thread t1 = new Thread(r, "e");
		Thread t2 = new Thread(r, "o");
		t1.start();
		t2.start();

	}

}
