package dev.greenadine.advancedspawners.util;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public final class Identifier {

    private static final Random RANDOM = new Random();

    private static final ArrayList<Long> SPAWNER_IDS = new ArrayList<>();
    private static final Queue<Long> QUEUED_IDS = new PriorityQueue<>(100);

    static {
        enqueueIds();
    }

    @SuppressWarnings("ConstantConditions")
    public static long nextId() {
        if (QUEUED_IDS.isEmpty()) {
            enqueueIds();
        }

        final long nextId = QUEUED_IDS.poll();
        SPAWNER_IDS.add(nextId);
        return nextId;
    }

    private static void enqueueIds() {
        for (int i = QUEUED_IDS.size(); i < 100; i++) {
            final long id = generateId();

            if (!SPAWNER_IDS.contains(id)) {
                QUEUED_IDS.add(id);
            }
        }
    }

    /**
     * Returns a pseudo-randomly generated number of the given length.
     *
     * @return a pseudo-randomly generated number of the given length.
     */
    private static long generateId() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                sb.append("123456789".toCharArray()[RANDOM.nextInt(9)]);
            } else {
                sb.append("0123456789".toCharArray()[RANDOM.nextInt(10)]);
            }
        }

        return Long.parseLong(sb.toString());
    }
}
