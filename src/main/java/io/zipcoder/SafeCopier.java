package io.zipcoder;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    private ReentrantLock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        String nextWord = "";

        try {
            //lock.lock();
            while (this.stringIterator.hasNext()) {

//                nextWord = this.stringIterator.next() + " ";
//                Thread.sleep(new Random().nextInt(20));
//                this.copied += nextWord;
                getWord();

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //lock.unlock();
        }

    }

    private synchronized void getWord() throws InterruptedException {
        if (this.stringIterator.hasNext()) {
            String nextWord = this.stringIterator.next() + " ";
            Thread.sleep(new Random().nextInt(50));
            System.out.println(Thread.currentThread().getName());
            this.copied += nextWord;
        }
    }
}
