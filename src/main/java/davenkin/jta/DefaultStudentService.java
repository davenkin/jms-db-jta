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
public class DefaultStudentService implements StudentService {

    public static final String INSERT_SQL = "insert into profile values('%s','%s')";
    private JmsTemplate jmsTemplate;
    private JdbcTemplate jdbcTemplate;
    private int in = 0;

    @Override
    @Transactional
    public void profileFromQueueToDB() throws JMSException {
        insertProfile(((TextMessage) jmsTemplate.receive()).getText());
//        throw new RuntimeException("xxxxx");
    }

    @Override
    @Transactional
    public void insertProfile(String message) {
        jdbcTemplate.execute(String.format(INSERT_SQL, message, message));
//        if (in++ < 3) {
            throw new RuntimeException("YYYYY");
//        }
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
