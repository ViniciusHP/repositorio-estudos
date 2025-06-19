package com.vhp.producer.service;

public interface AmqpService<T> {
    void sendToConsumer(T t);
}
