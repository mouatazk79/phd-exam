package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.model.News;
import klaa.mouataz.edlli.repos.InformationRepository;
import klaa.mouataz.edlli.services.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService {
    private final InformationRepository informationRepository;
    @Override
    public News getById(Integer id) {
        return informationRepository.findInformationById(id);
    }

    @Override
    public List<News> getAll() {
        return informationRepository.findAll();
    }

    @Override
    public News save(News information) {
        return informationRepository.save(information);
    }

    @Override
    public void deleteById(Integer id) {
       informationRepository.deleteById(id);
    }

    @Override
    public News updateInformation(News information) {
        return null;
    }
}
