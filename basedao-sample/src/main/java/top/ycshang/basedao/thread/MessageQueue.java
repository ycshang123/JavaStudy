package top.ycshang.basedao.thread;

import java.util.LinkedList;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-27 00:03
 **/
class MessageQueue {
    private final LinkedList<Message> list = new LinkedList<>();
    /**
     * 容量
     */
    private final int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }
    /**
     * 生产
     */
    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                System.out.println("队列已满，生产者等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            System.out.println("生产消息:" + message);
            // 生产后通知消费者
            list.notifyAll();
        }
    }

    public Message take() {
        synchronized (list) {
            while (list.isEmpty()) {
                System.out.println("队列已空，消费者等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            System.out.println("消费消息:" + message);
            // 消费后通知生产者
            list.notifyAll();
            return message;
        }
    }


}