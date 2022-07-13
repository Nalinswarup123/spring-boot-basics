package com.spring.springdata.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("{id}")
	public Topic getTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void createTopic(@RequestBody Topic topic) {
		topicService.createTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public void updateTopic(@PathVariable int id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteTopic(@PathVariable int id) {
		topicService.deleteTopic(id);
	}

}
