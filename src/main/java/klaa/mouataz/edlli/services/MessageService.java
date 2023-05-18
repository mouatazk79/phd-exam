package klaa.mouataz.edlli.services;


import klaa.mouataz.edlli.model.Message;

import java.util.List;

public interface MessageService {
    Message getById(Integer id);
    List<Message> getAll();
    Message save(Message message);
    void deleteById(Integer id);


}
