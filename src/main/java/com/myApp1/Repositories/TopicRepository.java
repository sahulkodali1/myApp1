package com.myApp1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp1.Model.Topic;

public interface TopicRepository extends JpaRepository<Topic,Integer>{

}
