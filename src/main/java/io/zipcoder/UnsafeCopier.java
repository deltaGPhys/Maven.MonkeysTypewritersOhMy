package io.zipcoder;

import java.util.Arrays;
import java.util.Random;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        String nextWord = "";
        try {
            while (this.stringIterator.hasNext()) {
                nextWord = this.stringIterator.next() + " ";
                Thread.sleep(new Random().nextInt(20));
                this.copied += nextWord;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
