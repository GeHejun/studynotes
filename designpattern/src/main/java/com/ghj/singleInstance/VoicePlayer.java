package com.ghj.singleInstance;

/**
 * @author gehj
 * @date 2019/6/2714:51
 */
public class VoicePlayer {
    public static volatile VoicePlayer voicePlayer;
    private VoicePlayer() {}

    public static VoicePlayer getInstance() {
        if (voicePlayer == null) {
            synchronized (VoicePlayer.class) {
                if (voicePlayer == null) {
                    voicePlayer = new VoicePlayer();
                }
            }
        }
        return voicePlayer;
    }

    public void paly(String src) {
        System.out.println("play 音乐,链接 "+ src);
    }

    public static void main(String[] args) {
        VoicePlayer.getInstance().paly("123...");
    }
}
