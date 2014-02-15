package davenkin.jta;

import javax.jms.JMSException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/5/14
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MessageConsumer {

    public void handleMessage(Object message) throws JMSException;
}
