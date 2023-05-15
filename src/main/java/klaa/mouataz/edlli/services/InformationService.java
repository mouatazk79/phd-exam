package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.News;

import java.util.List;

public interface InformationService {
    News getById(Integer id);
    List<News> getAll();
    News save(News information);
    void deleteById(Integer id);
    News updateInformation(News information);
}
