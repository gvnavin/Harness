package com.company;
/**

 foo(Object object1, Object object2) {
    synchronize(object1) {
        synchronize(object2) {

        }
    }
 }

 Object obj1 = new Object()
 Object obj2 = new Object()

 foo(obj1, obj2)
 foo(obj2, obj1)

 1. clone - shallow clone
 2. using hashcode

 sending bids
 aggregating the bids
 all binds sorting based on bid price

 class Bid {
    int value;
    int bidProviderId;
    int targetId;
 }

 bidqueue = new BidQueue();
 bidqueue.push(bid)

 Person {

 Person() {
    bidq = BidQueue
 }

 class Bidqueue {
    //synchronize
 }

    bid(int bidValue) {
        bidq.push(new Bid(bidValue, id, "carID"))
    }

    Set sortedBidset = new TreeSet(new Comparator() {
        public int compare(Bid o1, Bid o2) {
            if (o1.value != o2.value) {
                return o1.value - o2.value;
            }
            if (o1.bidProviderId != o2.bidProviderId) {
                return o1.bidProviderId - o2.bidProviderId;
            }
    //...
 }
 }
 })

    Thread(new Runnable() {
    void run() {
       if (bidq.empty()) {
            thread.Sleep(5*1000);
        }
        while(!bidq.isEmpty()) {
            bid = bidq.pop()
            sortedBidset(bid)
        }
 }
 }
 )

 }

 */
public class Deadlock {

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
                            order.wait();
                            System.out.println("even = " + even);
                            order.notify();
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
                        order.wait();
                        System.out.println("odd = " + odd);
                        order.notify();
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
