package davenkin.jta;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/4/14
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultProfileService implements ProfileService {

    private JmsTemplate jmsTemplate;
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void profileFromQueueToDB() throws JMSException {
        TextMessage message = (TextMessage) jmsTemplate.receive();

        jdbcTemplate.execute("insert into profile values('" + message.getText() + "','" + message.getText() + "')");
        throw new RuntimeException("xxxxx");
    }

    @Required
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Required
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
