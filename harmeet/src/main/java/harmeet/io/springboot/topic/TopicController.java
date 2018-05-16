package harmeet.io.springboot.topic;

import java.util.List;

import org.crsh.shell.impl.command.system.help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return  topicService.getAllTopics();
	}
	
	@RequestMapping("/verTest")
	public String getVerTest(){
		return  "verTest";
	}
	
	@RequestMapping("api/v1/verTest")
	public String getAllTopicsURI(){
		return  "verTest+URI";
	}
	
	@GetMapping(value="/verTest/header", headers="X-API-VERSION=1")
	public String getAllTopicsHeader(){
		return  "verTest+Header";
	}
	
	@RequestMapping(value="/verTest", produces="application/v1+json" )
	public String getAllTopicsProduces(){
		return  "verTest+Produces";
	}
	
	@RequestMapping(value= "/verTest", params="version=1")
	public String getAllTopicsParams(){
		return  "verTest+Params";
	}
	
	@RequestMapping("/topics/{foo}")
	public Topic getTopic(@PathVariable("foo") String id) //mapping foo to id
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/topics") //Post Request JSON to actual instance converted by Spring MVC
	public void addTopic(@RequestBody  Topic topic)
	{
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{id}") //PUT Request and Delete are same
	public void updateTopic(@RequestBody  Topic topic , @PathVariable String id)
	{
		topicService.updateTopic(id , topic);
	}
}
