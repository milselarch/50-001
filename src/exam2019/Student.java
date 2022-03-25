package exam2019;

//starting code
public class Student implements Observer {
    private String id;

    public Student(String id, TemperatureAlert alert) {
        this.id = id;
        alert.register(this);
    }

    public void update(int t) {
        System.out.format(
            "Student %s receives temperature alert: %s\n",
            this.id, t
        );
    }
}
