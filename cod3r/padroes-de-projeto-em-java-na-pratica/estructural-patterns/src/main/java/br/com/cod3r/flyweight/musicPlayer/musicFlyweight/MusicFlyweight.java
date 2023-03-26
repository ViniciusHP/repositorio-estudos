package br.com.cod3r.flyweight.musicPlayer.musicFlyweight;

public class MusicFlyweight {
	private final String name;
	private final String artist;
	private final Integer durationInSeconds;

	public MusicFlyweight(String name, String artist, Integer durationInSeconds) {
		this.name = name;
		this.artist = artist;
		this.durationInSeconds = durationInSeconds;
	}
	
	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public Integer getDurationInSeconds() {
		return durationInSeconds;
	}

	@Override
	public String toString() {
		return "MusicFlyweight [name=" + name + ", artist=" + artist + ", durationInSeconds=" + durationInSeconds + "]";
	}
}
