package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.StudentCSVRecord;

import java.io.File;
import java.util.List;

public interface UserCSVService {
    public List<StudentCSVRecord> convertCSV(File file);
}

