package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.Message;
import klaa.mouataz.edlli.repos.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    public Message getById(Integer id) {
        return messageRepository.findMessageById(id);
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public void deleteById(Integer id) {
       messageRepository.deleteById(id);
    }
}
