package harmeet.io.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring" ,"spring framework" ,"Spring Frameworkdesc"),
			new Topic("Spring1" ,"spring framework1" ,"Spring Frameworkdesc1"),
			new Topic("Spring2" ,"spring framework2" ,"Spring Frameworkdesc2")
			));
    
    public List<Topic> getAllTopics()
    {
    	return topics;
    }
    
    public Topic getTopic(String id)
    {
    	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
    
    public void addTopic(Topic topic)
    {
    	topics.add(topic);
    }

	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		for(int i=0 ; i < topics.size() ; i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
	}
}
