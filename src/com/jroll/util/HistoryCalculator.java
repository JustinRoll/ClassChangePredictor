package com.jroll.util;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.List;

/**
 * Created by jroll on 1/28/16.
 */
public class HistoryCalculator {

    public static double ln(int number) {
        return (-Math.log(1 - number)) / number;
    }


    /*
        For each class, keep track of the occasions it was modified. Calculate the log weighted
     */
    public static double getLogHistory(Integer ticketCount, List<AbstractMap.SimpleEntry<Integer, LocalDateTime>> simpleEntries) {
        Double accumulated = 0d;
        final int LOG_LOWER_BOUND = 3;
        for (AbstractMap.SimpleEntry<Integer, LocalDateTime> entry : simpleEntries) {
            Integer k = (ticketCount - entry.getKey()) + 1;
            if (k < LOG_LOWER_BOUND) {
                accumulated += 1;
            }
            else {
                accumulated += 1 / ln(k);
            }
        }

        return ticketCount == 0 || accumulated.isNaN()  ? 0 : accumulated / ticketCount;
    }

    /* Calculate commit weight logarithmic */
    public static double getWeightedHistory(Integer ticketCount, List<AbstractMap.SimpleEntry<Integer, LocalDateTime>> simpleEntries) {
        double accumulated = 0;

        for (AbstractMap.SimpleEntry<Integer, LocalDateTime> entry : simpleEntries) {
            Integer k = (ticketCount - entry.getKey()) + 1;

                accumulated += 1 / k;

        }
        return ticketCount == 0 ? 0 : accumulated / ticketCount;
    }
    /* Calculate commit weight */

    /* Just add */

}
