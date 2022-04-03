package org.example.sweater.repositories;

import org.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    public List<Message> findByTag(String tag);
}
