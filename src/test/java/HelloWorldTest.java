import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * Created with IntelliJ IDEA.
 * User: davenkin
 * Date: 3/12/13
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */

@Ignore
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldTest {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;


    @Test
    public void testHello(){
        jmsTemplate.send(queue,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("This is a test message.");
            }
        });
    }

}
