package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.News;
import klaa.mouataz.edlli.repos.InformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InformationService {
    private final InformationRepository informationRepository;
    public News getById(Integer id) {
        return informationRepository.findInformationById(id);
    }

    public List<News> getAll() {
        return informationRepository.findAll();
    }

    public News save(News information) {
        return informationRepository.save(information);
    }

    public void deleteById(Integer id) {
       informationRepository.deleteById(id);
    }

    public News updateInformation(News information) {
        return null;
    }
}
