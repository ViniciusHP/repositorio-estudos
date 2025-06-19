package com.vhp.producer.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
