package br.com.cod3r.iterator.tvChannel;

public class Client {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.searchAvaiableChannels();

		for(Integer channel : tv) {
			System.out.println(String.format("Zapping at channel #%d", channel));
		}
	}
}
