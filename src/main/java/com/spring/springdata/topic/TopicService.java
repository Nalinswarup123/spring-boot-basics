package com.spring.springdata.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository repository;
	
	private int newId = 1;
	
	public Topic getTopic(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		repository.findAll().forEach(topics::add);
		return topics;
	}

	public void createTopic(Topic topic) {
		topic.setId(newId++);
		repository.save(topic);
	}
	
	public void updateTopic(int id, Topic topic) {
		repository.save(topic);
	}
	
	public void deleteTopic(int id) {
		repository.deleteById(id);
	}
}
