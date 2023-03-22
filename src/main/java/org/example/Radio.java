package org.example;

public class Radio {

    private int stationNumber;
    private int currentVolume;

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume += 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume -= 1;
        }
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            return;
        }
        if (volume > 100) {
            return;
        }
        currentVolume = volume;
    }

    public int getVolume() {
        return currentVolume;
    }

    public void nextStation() {
        if (stationNumber == 9) {
            stationNumber = 0;
        } else {
            stationNumber++;
        }
    }

    public void prevStation() {
        if (stationNumber == 0) {
            stationNumber = 9;
        } else {
            stationNumber--;
        }
    }

    public void setStation(int station) {
        if (station < 0) {
            return;
        }
        if (station > 9) {
            return;
        }
        stationNumber = station;
    }

    public int getStation() {
        return stationNumber;
    }
}
