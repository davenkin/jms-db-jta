import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/3/14
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hello {

    public static void main(String[] args) throws JMSException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");


        JmsTemplate message = (JmsTemplate) applicationContext.getBean("producerTemplate");
                       message.send(new MessageCreator() {
                           public Message createMessage(Session session) throws JMSException {
                               TextMessage message  = session.createTextMessage("test message from spring");
                               message.setStringProperty("text", "Hello World1w");
                               return message;
                           }
                       });

//        Message receive = message.receive();
//        System.out.println(receive);
    }}
