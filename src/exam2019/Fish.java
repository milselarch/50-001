package exam2019;

public class Fish implements Observer {
    private String id;

    public Fish(String id, TemperatureAlert alert) {
        this.id = id;
        alert.register(this);
    }

    public void update(int t) {
        System.out.format(
            "Fish %s receives temperature alert: %s\n",
            this.id, t
        );
    }
}
