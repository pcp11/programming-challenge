package de.exxcellent.challenge.parser;

import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public interface FileParser<T> {

    List<T> parseFile(String filePath);
}
