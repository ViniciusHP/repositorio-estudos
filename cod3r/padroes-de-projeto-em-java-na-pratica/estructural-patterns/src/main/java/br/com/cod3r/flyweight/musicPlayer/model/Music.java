package br.com.cod3r.flyweight.musicPlayer.model;

import br.com.cod3r.flyweight.musicPlayer.musicFlyweight.MusicFlyweight;

public class Music {
	private MusicFlyweight musicFlyweight;
	private Integer playerQty;
	
	public Music(MusicFlyweight flyweight) {
		this.musicFlyweight = flyweight;
		this.playerQty = 0;
	}
	
	public void listenning() {
		playerQty++;
	}

	public Integer getPlayerQty() {
		return playerQty;
	}

	public void setPlayerQty(Integer playerQty) {
		this.playerQty = playerQty;
	}

	public MusicFlyweight getMusicFlyweight() {
		return musicFlyweight;
	}

	public void setMusicFlyweight(MusicFlyweight musicFlyweight) {
		this.musicFlyweight = musicFlyweight;
	}

	@Override
	public String toString() {
		return "Music{" +
				"flyweight=" + musicFlyweight +
				", playerQty=" + playerQty +
				'}';
	}
}
