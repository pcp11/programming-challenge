package de.exxcellent.challenge.parser;

import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public interface FileParser<T> {

    /**
     * Parses the given file and returns a List containing all available entries.
     *
     * @param filePath the file's path
     * @return List containing all available entries
     */
    List<T> parseFile(String filePath);
}
