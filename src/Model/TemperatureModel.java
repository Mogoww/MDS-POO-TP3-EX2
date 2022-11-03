package Model;

import java.util.Observable;

public class TemperatureModel extends Observable {

    private double temperatureC = 20;

    public double getC() {
        return temperatureC;
    }

    public void setC(double tempC) {
        temperatureC = tempC;
        setChanged();
        notifyObservers();
    }

    public double getF() {
        return (temperatureC * 9 / 5) + 32;
    }

    public void setF(double tempF) {
        temperatureC = (tempF - 32) * 5 / 9;
        setChanged();
        notifyObservers();
    }
}
