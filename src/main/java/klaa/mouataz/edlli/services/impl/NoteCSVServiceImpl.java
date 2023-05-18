package klaa.mouataz.edlli.services.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import klaa.mouataz.edlli.model.NoteCSVRecord;
import klaa.mouataz.edlli.services.NoteCSVService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
@Service
public class NoteCSVServiceImpl implements NoteCSVService {
    @Override
    public List<NoteCSVRecord> convertCSV(File file) {
        try {
            List<NoteCSVRecord>  noteCSVRecords=new CsvToBeanBuilder<NoteCSVRecord>(new FileReader(file)).withType(NoteCSVRecord.class).build().parse();
            return noteCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
