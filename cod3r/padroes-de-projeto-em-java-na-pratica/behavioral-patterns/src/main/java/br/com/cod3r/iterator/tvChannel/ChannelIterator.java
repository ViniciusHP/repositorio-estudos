package br.com.cod3r.iterator.tvChannel;

import java.util.Iterator;

public class ChannelIterator implements Iterator<Integer> {
    private Integer[] channels;
    private int index = 0;
    public ChannelIterator(Integer[] channels) {
        this.channels = channels;
    }

    @Override
    public boolean hasNext() {
        if(channels == null) return false;
        return index <= channels.length - 1 && channels[index] != null;
    }

    @Override
    public Integer next() {
        return channels[index++];
    }
}
