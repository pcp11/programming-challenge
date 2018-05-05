package de.exxcellent.challenge;

import de.exxcellent.challenge.parser.FileParser;

import java.util.Comparator;
import java.util.List;

/**
 * @author pc
 * @since 05.05.18
 */
public class FileSelector<T> {

    private String filePath;

    private FileParser<T> fileParser;

    private Comparator<T> comparator;

    public FileSelector(String filePath, FileParser<T> fileParser, Comparator<T> comparator) {
        this.filePath = filePath;
        this.fileParser = fileParser;
        this.comparator = comparator;
    }

    public T select() {
        List<T> fileEntries = fileParser.parseFile(filePath);
        T max = null;
        for (int i = 0; i < fileEntries.size(); ++i) {
            T current = fileEntries.get(i);
            if (i == 0 || comparator.compare(current, max) > 0) {
                max = current;
            }
        }
        return max;
    }
}
