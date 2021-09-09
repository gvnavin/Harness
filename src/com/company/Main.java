package com.company;
/**
 * abstract vs interface
 * <p>
 * program 2 thread 1 to 100
 * thread even and odd numbers
 * <p>
 * s1 -> fast service
 * s2 -> delayed service - stops responding
 * circuit breaker ->
 * configurable retries
 * custom exceptions
 * back off time
 * exponential
 * fall back is fast service
 * <p>
 * RetryConfig {
 * <p>
 * }
 * <p>
 * CircuitState {
 * OPEN
 * CLOSED
 * HALF_OPEN
 * }
 * <p>
 * ServiceWrapper {
 * tryCalling() {
 * <p>
 * if (state == HALF_OPEN) {
 * response = service1.ping()
 * if (response.success) {
 * circuitState = closed
 * } else {
 * invokeService1()
 * }
 * }
 * <p>
 * while(retries>0) {
 * try {
 * response = service1.call()
 * circuitState = closed
 * return response
 * } catch(Exception e) {
 * circuitState = open;
 * Thread.sleep(waitTime^times)
 * }
 * }
 * state = half_open
 * //retry == 0
 * return invokeService1()
 * }
 * }
 */
public class Main {

    static Object order = new Object();

    public static void main(String[] args) {
        // write your code here

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int even = 0;
                    while (even < 10) {
                        synchronized (order) {
                            order.notify();
                            System.out.println("even = " + even);
                            order.wait();
                        }
                        even += 2;
                    }
                } catch (Exception e) {
                }
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                int odd = 1;
                while (odd < 10) {
                    synchronized (order) {
                        order.notify();
                        System.out.println("odd = " + odd);
                        order.wait();
                    }
                    odd += 2;
                }
                } catch (Exception e) {
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
