package davenkin.jta;

import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.List;
import java.util.Random;


@Controller
public class StudentController {

    private final Random random = new Random(52434);
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/displayDB", method = RequestMethod.GET)
    @ResponseBody
    public String displayDB() {
        List<Student> students = jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<Student>(Student.class));
        return "Records in DB: " + Joiner.on(" | ").join(students);
    }

    @RequestMapping(value = "/insertDB", method = RequestMethod.GET)
    @ResponseBody
    public String insertDB() throws JMSException {
        jdbcTemplate.execute("insert into student values('" + random.nextInt(1000) + "','" + random.nextInt(1000) + "')");
        return "Record inserted into database";
    }

    @RequestMapping(value = "/insertQ", method = RequestMethod.GET)
    @ResponseBody
    public String insertQ() {
        final String randomNumber = String.valueOf(random.nextInt(1000));

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(randomNumber);
            }
        });
        return " Inserted one queue[" + randomNumber + "] into MyQueue";
    }

    @RequestMapping(value = "/receiveQ", method = RequestMethod.GET)
    @ResponseBody
    public String receiveQ() throws JMSException {

        TextMessage message = (TextMessage) jmsTemplate.receive();
        return "Received one queue from MyQueue: " + message;
    }

    @RequestMapping(value = "/fromQueueToDB", method = RequestMethod.GET)
    @ResponseBody
    public String fromQueueToDB() throws JMSException {
        studentService.moveStudentFromQueueToDB();
        return "Queue transferred from Queue to DB";
    }

}