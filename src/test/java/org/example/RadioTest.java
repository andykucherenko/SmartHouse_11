package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    Radio station = new Radio();

    @Test
    public void shouldGetCurrentStation() {
        station.setCurrentStation(0);
        station.setCurrentStation(-1);
        station.setCurrentStation(11);
        assertEquals(0, station.getCurrentStation());
    }

    @Test
    public void shouldPressNextStation() {
        station.setCurrentStation(0);
        station.pressNextStation();
        assertEquals(1, station.getCurrentStation());

        station.setCurrentStation(10);
        station.pressNextStation();
        assertEquals(0, station.getCurrentStation());

        station.setCurrentStation(-1);
        station.pressNextStation();
        assertEquals(0, station.getCurrentStation());

        station.setCurrentStation(11);
        station.pressNextStation();
        assertEquals(1, station.getCurrentStation());
    }

    @Test
    public void shouldPressPrevStation() {
        station.setCurrentStation(0);
        station.pressPrevStation();
        assertEquals(10, station.getCurrentStation());

        station.setCurrentStation(10);
        station.pressPrevStation();
        assertEquals(9, station.getCurrentStation());
    }

    @Test
    public void shouldGetToMaxStation() {
        assertEquals(10, station.getMaxRadioStation());
    }

    @Test
    public void shouldSetMaxStation() {
        station.setMaxRadioStation(-1);
        station.setMaxRadioStation(0);
        station.setMaxRadioStation(11);
        assertEquals(11, station.getMaxRadioStation());
    }

    @Test
    public void shouldGetToMinStation() {
        assertEquals(0, station.getMinRadioStation());
    }

    @Test
    public void shouldSetMinStation() {
        station.setMinRadioStation(-1);
        station.setMinRadioStation(0);
        station.setMinRadioStation(11);
        assertEquals(11, station.getMinRadioStation());
    }

    @Test
    public void shouldSetCurrentVolume() {
        station.setCurrentVolume(101);
        assertEquals(0, station.getCurrentVolume());

        station.setCurrentVolume(-1);
        assertEquals(100, station.getCurrentVolume());

        station.setCurrentVolume(8);
        assertEquals(8, station.getCurrentVolume());
    }

    @Test
    public void shouldGetMinVolume() {
        assertEquals(0, station.getMinVolume());
    }

    @Test
    public void shouldGetMaxVolume() {
        assertEquals(100, station.getMaxVolume());
    }

    @Test
    public void shouldSetMinVolume() {
        station.setMaxVolume(100);
        station.setMinVolume(1);
        assertEquals(1, station.getMinVolume());
    }

    @Test
    public void shouldSetMaxVolume() {
        station.setMinVolume(1);
        station.setMaxVolume(101);
        assertEquals(101, station.getMaxVolume());
    }

    @Test
    public void shouldPressVolumeUp() {
        station.setCurrentVolume(4);
        station.pressVolumeUp();
        assertEquals(5, station.getCurrentVolume());

        station.setCurrentVolume(100);
        station.pressVolumeUp();
        assertEquals(0, station.getCurrentVolume());
    }

    @Test
    public void shouldPressVolumeDown() {
        station.setCurrentVolume(4);
        station.pressVolumeDown();
        assertEquals(3, station.getCurrentVolume());

        station.setCurrentVolume(0);
        station.pressVolumeDown();
        assertEquals(100, station.getCurrentVolume());
    }

    @Test
    public void shouldCreateStationsWithLimits() {
        Radio radio = new Radio(1);
        assertEquals(0, radio.getMaxRadioStation());

        Radio radio1 = new Radio(100);
        assertEquals(99, radio1.getMaxRadioStation());

        Radio radio2 = new Radio(10);
        assertEquals(0, radio2.getMinRadioStation());
    }
}