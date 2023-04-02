package klaa.mouataz.edlli.services.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import klaa.mouataz.edlli.model.StudentCSVRecord;
import klaa.mouataz.edlli.services.UserCSVService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
@Service
public class UserCSVServiceImpl implements UserCSVService {
    @Override
    public List<StudentCSVRecord> convertCSV(File file) {
        try {
            List<StudentCSVRecord>  studentCSVRecords=new CsvToBeanBuilder<StudentCSVRecord>(new FileReader(file)).withType(StudentCSVRecord.class).build().parse();
            return studentCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
