package org.katiesh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class BusinessLogger {
    private final String prefix;
    private final Path logFile = Path.of("business.log");

    public BusinessLogger(String prefix) {
        this.prefix = prefix;
    }

    public void log(String message) {
        try {
            Files.writeString(
                    logFile,
                    prefix + " " + message + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(
                    prefix + " couldn't write to log file: " + message + ": at " + Instant.now());;
        }
    }
}
