package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class Radio {
    private int currentStation = 10;
    private int maxRadioStation = 10;
    private int minRadioStation = 0;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;


    public Radio(int generateNewStation) {
        this.currentStation = generateNewStation;
        maxRadioStation = generateNewStation - 1;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > maxRadioStation) {
            currentStation = minRadioStation;
        }
        if (currentStation < minRadioStation) {
            currentStation = maxRadioStation;
        }
        this.currentStation = currentStation;
    }

    public void pressNextStation() {
        if (currentStation >= maxRadioStation) {
            setCurrentStation(minRadioStation);
        } else {
            setCurrentStation(currentStation + 1);
        }
    }

    public void pressPrevStation() {
        if (currentStation <= minRadioStation) {
            setCurrentStation(maxRadioStation);
        } else {
            setCurrentStation(currentStation - 1);
        }
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            currentVolume = minVolume;
        }
        if (currentVolume < minVolume) {
            currentVolume = maxVolume;
        }
        this.currentVolume = currentVolume;
    }

    public void pressVolumeUp() {
        setCurrentVolume(currentVolume + 1);
    }

    public void pressVolumeDown() {
        setCurrentVolume(currentVolume - 1);
    }
}
