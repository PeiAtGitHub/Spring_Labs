package pei.spring.boot.lab.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("Fishing101", "Fishing 101", "How to catch a fish in a river or lake."),
				new Topic("StarGz", "Star Gazing", "You will get to know the night sky."),
				new Topic("Chess", "Chess", "Introduction to the game of Chess.")
				);
	}
}
