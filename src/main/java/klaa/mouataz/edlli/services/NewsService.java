package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.News;
import klaa.mouataz.edlli.repos.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    public News getById(Integer id) {
        return newsRepository.findNewsById(id);
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public void deleteById(Integer id) {

        newsRepository.deleteById(id);
    }

    public News updateNews(News news) {
        return newsRepository.save(news);
    }
}
