package davenkin.jta;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/5/14
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultMessageConsumer implements MessageConsumer {
    private StudentService studentService;

    @Override
    @Transactional
    public void handleMessage(Object message) throws JMSException {
        studentService.insertProfile((String) message);
    }

    @Required
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
