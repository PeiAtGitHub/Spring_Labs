package pei.spring.boot.lab.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Service @Getter
public class TopicService {
	
	
	private List<Topic> topics = Arrays.asList(
			new Topic("Fishing101", "Fishing 101", "How to catch a fish in a river or lake."),
			new Topic("StarGz", "Star Gazing", "You will get to know the night sky."),
			new Topic("Chess", "Chess", "Introduction to the game of Chess.")
			);
	
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
	}

}
