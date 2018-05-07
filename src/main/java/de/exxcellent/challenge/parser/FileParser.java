package de.exxcellent.challenge.parser;

import java.util.List;

/**
 * Provides a parser, that takes a csv file converting it into a List
 * of generic objects.
 *
 * @author Patrick Christ
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
