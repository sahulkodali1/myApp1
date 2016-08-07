package com.myApp1.Rest.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myApp1.Model.Topic;
import com.myApp1.Service.TopicService;

@RestController
@RequestMapping("course/Topic")
public class TopicController {
	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/createTopic", method = RequestMethod.POST)
	public ResponseEntity<Topic> CreateTopic(@Valid @RequestBody Topic topic) throws Exception {
		return new ResponseEntity<Topic>(topicService.save(topic), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/deletetopic", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deletetopic(@PathVariable Integer topicId) throws Exception {
		topicService.deleteTopic(topicId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(value = "/updateTopic", method = RequestMethod.PUT)
	public ResponseEntity<Topic> updatetopic(@Valid @RequestBody Topic topic) throws Exception {
		return new ResponseEntity<Topic>(topicService.save(topic), HttpStatus.OK);
	}
	


}
