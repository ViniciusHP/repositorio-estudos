package br.com.cod3r.flyweight.musicPlayer.musicFlyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static FlyweightFactory instance = new FlyweightFactory();
    private static Map<String, MusicFlyweight> musicFlyRepository;

    private FlyweightFactory(){
        musicFlyRepository = new HashMap<>();
    }

    public static FlyweightFactory getInstance() {
        return instance;
    }

    public MusicFlyweight getMusic(String desc) {
        MusicFlyweight mf = musicFlyRepository.get(desc);
        if(mf == null) {
            System.out.println("Creating new Flyweight for " + desc);
            mf = getMusicByString(desc);
            musicFlyRepository.put(desc, mf);
        }

        return mf;
    }

    private MusicFlyweight getMusicByString(String desc) {
        String[] musicData = desc.split(";");
        return new MusicFlyweight(musicData[0], musicData[1], Integer.valueOf(musicData[2]));
    }

    public Integer getSize() {
        return musicFlyRepository.size();
    }
}
