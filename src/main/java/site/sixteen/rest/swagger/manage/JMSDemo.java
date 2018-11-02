/**
 * @projectName rest-swagger
 * @package site.sixteen.rest.swagger.manage
 * @className site.sixteen.rest.swagger.manage.JMSDemo
 * @copyright Copyright 2018 Thuisoft, Inc. All rights reserved.
 */
package site.sixteen.rest.swagger.manage;

import lombok.extern.slf4j.Slf4j;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * JMSDemo
 *
 * @author panhainan
 * @version 1.0
 * @description JMS示例
 * @date 2018/11/2 18:05
 */
@Slf4j
public class JMSDemo {
    /**
     * 获取连接工厂
     * 使用连接工厂创建连接
     * 启动连接
     * 从连接创建会话
     * 获取 Destination
     * 创建 Producer，或
     * 创建 Producer
     * 创建 message
     * 创建 Consumer，或发送或接收message发送或接收 message
     * 创建 Consumer
     * 注册消息监听器（可选）
     * 发送或接收 message
     * 关闭资源（connection, session, producer, consumer 等)
     */
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;
        MessageConsumer consumer = null;
        Message message = null;
        boolean useTransaction = false;
        try {
            Context ctx = new InitialContext();
            connectionFactory = (ConnectionFactory)ctx.lookup("ConnectionFactoryName");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("TEST.QUEUE");
            producer = session.createProducer(destination);
            message = session.createTextMessage("this is a test text");
            producer.send(message);
            consumer = session.createConsumer(destination);
            message = consumer.receive(1000);
            log.info("Received message: {}", message);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message != null) {
                        // doMessageEvent(message);
                    }
                }
            });

        } catch (NamingException | JMSException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (producer != null) {
                    producer.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                log.error(e.getMessage(), e);
            }

        }
    }

}
