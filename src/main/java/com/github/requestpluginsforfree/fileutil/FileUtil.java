package com.github.requestpluginsforfree.fileutil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;

public final class FileUtil {
    private final static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    /**
     * This will write the input to file async
     *
     * @param file file instance that we're writing on
     * @param input the input that we're writing to file
     * @apiNote avoid using methods that are not thread-safe (bukkit)
     */
    public static void writeAsync(final File file, final String input){
        executor.execute(() -> {
            try (final FileWriter writer = new FileWriter(file)) {
                writer.write(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * This method will perform the consumer operation async
     *
     * @param file file instance that we're writing on
     * @param consumer the consumer that you'll be performing on
     * @apiNote avoid using methods that are not thread-safe (bukkit)
     */
    public static void writeAsync(final File file, final Consumer<FileWriter> consumer){
        executor.execute(() -> {
            try {
                consumer.accept(new FileWriter(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * This method will perform the consumer operation async
     *
     * @param file file instance that we're reading on
     * @param consumer the consumer that you'll be performing on
     * @apiNote avoid using methods that are not thread-safe (bukkit)
     */
    public static void readAsync(final File file, final Consumer<FileReader> consumer){
        executor.execute(() -> {
            try {
                consumer.accept(new FileReader(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
