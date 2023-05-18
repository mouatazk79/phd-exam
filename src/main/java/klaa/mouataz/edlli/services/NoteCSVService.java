package klaa.mouataz.edlli.services;


import klaa.mouataz.edlli.model.NoteCSVRecord;

import java.io.File;
import java.util.List;

public interface NoteCSVService {
    public List<NoteCSVRecord> convertCSV(File file);

}
