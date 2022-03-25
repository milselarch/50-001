package exam2019;

import java.util.ArrayList;

public class TemperatureAlert implements Subject {
    private int temperature;
    private final ArrayList<Observer> observers;

    public TemperatureAlert() {
        this.observers = new ArrayList<>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        if ((temperature < 10) || (temperature > 35)) {
            this.notifyObservers();
        }
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this.temperature);
        }
    }
}

