package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.model.News;
import klaa.mouataz.edlli.repos.NewsRepository;
import klaa.mouataz.edlli.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    @Override
    public News getById(Integer id) {
        return newsRepository.findNewsById(id);
    }

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteById(Integer id) {

        newsRepository.deleteById(id);
    }

    @Override
    public News updateNews(News news) {
        return newsRepository.save(news);
    }
}
