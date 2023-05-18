package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.model.Message;
import klaa.mouataz.edlli.repos.MessageRepository;
import klaa.mouataz.edlli.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    @Override
    public Message getById(Integer id) {
        return messageRepository.findMessageById(id);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteById(Integer id) {
       messageRepository.deleteById(id);
    }
}
