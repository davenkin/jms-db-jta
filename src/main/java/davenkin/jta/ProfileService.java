package davenkin.jta;

import javax.jms.JMSException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/4/14
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProfileService {

    public void profileFromQueueToDB() throws JMSException;
}
