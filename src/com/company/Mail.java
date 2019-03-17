package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  Mail queue.
 *  @version 1.0 17.03.2019
 *  @author Sergey Kotov
 */

public class Mail {
    private Queue<People> turnOnMail;
    private int number = 0;

    /** The constructor creates a comparator and priority queue.*/
    public Mail() {
        Comparator<People> comparator = new Comparator<People>() {
            @Override
            public int compare(final People o1, final People o2) {
                if (o1.isPensioner() && !o2.isPensioner()) {
                    return -1;
                }
                if (!o1.isPensioner() && o2.isPensioner()) {
                    return 1;
                }
                if (o1.getNumberOfQueque() > o2.getNumberOfQueque()) {
                    return 1;
                }
                if (o1.getNumberOfQueque() < o2.getNumberOfQueque()) {
                    return -1;
                }
                    return 0;
            }
        };

        turnOnMail = new PriorityQueue<>(comparator);
    }

    /**Adds a person to the queue.*/
    public final void addPeople(final People people) {
        people.setNumberOfQueque(number++);
        turnOnMail.add(people);
    }
    /**Remove a person to the queue.*/
    public final People pullPeople() {
        return turnOnMail.poll();
    }
}
