package br.com.cod3r.iterator.tvChannel;

import java.security.SecureRandom;
import java.util.Iterator;

public class TV implements Iterable<Integer>{
	private Integer[] channels;
	
	public void searchAvaiableChannels() {
		this.channels = new Integer[30];
		SecureRandom r = new SecureRandom();
		int channelsCount = 0;
		for(int i = 0; i < channels.length; i++) {
			if(r.nextInt(2) == 1) {
				channels[channelsCount++] = i;
			}
		}
		System.out.println(String.format("Found %d channels...", channelsCount));
	}

	public void accessChannel(Integer number) {
		System.out.print(String.format("Channel %d: ", number));
		for(int i = 0; i < channels.length; i++) {
			if(channels[i] == number) {
				System.out.println("OK!");
				return;
			}
		}
		System.out.println("No signal!");
	}

	@Override
	public Iterator<Integer> iterator() {
		return new ChannelIterator(channels);
	}
}
