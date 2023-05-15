package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.News;

import java.util.List;

public interface NewsService {
    News getById(Integer id);
    List<News> getAll();
    News save(News news);
    void deleteById(Integer id);
    News updateNews(News news);
}
