package piano;

public class InstrumentTest {
    public static void main(String[] args) {
        PianoMachine pm = new PianoMachine();
        System.out.println(pm.instrument);
        pm.changeInstrument();
        System.out.println(pm.instrument);
    }
}