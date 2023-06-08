package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.model.StudentCSVRecord;
import klaa.mouataz.edlli.services.StudentService;
import klaa.mouataz.edlli.services.UserCSVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo-controller")
public class DemoController {
  private final UserCSVService userCSVService;

  @PostMapping("/add/csv")
  public void csv(@RequestParam("file") MultipartFile csvFile) {
//    File file = convertMultipartFileToFile(csvFile);
//    List<StudentCSVRecord> studentCSVRecords = userCSVService.convertCSV(file);

  }


  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

}
