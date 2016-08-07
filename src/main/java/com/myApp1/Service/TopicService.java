package com.myApp1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp1.Exception.TopicNotFound;
import com.myApp1.Model.Topic;
import com.myApp1.Repositories.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public Topic save(Topic topic) throws Exception {
		return topicRepository.save(topic);
	}

	public void deleteTopic(Integer topicId) throws Exception {
		Topic topic = topicRepository.findOne(topicId);
		if (topic != null) {
			topicRepository.delete(topicId);
		} else {
			throw new TopicNotFound("search for " + topicId + " is failed");
		}

	}
}
