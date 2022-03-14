package midi;

import music.Pitch;
import piano.PianoMachine;

import javax.sound.midi.MidiUnavailableException;

public class MidiTest {
    public static void main(String[] args) throws MidiUnavailableException {
        Midi midi = Midi.getInstance();
        midi.clearHistory();
        PianoMachine pm = new PianoMachine();

        /*
        pm.beginNote(new Pitch(0));
        pm.beginNote(new Pitch(0));
        Midi.rest(50);
        pm.endNote(new Pitch(0));
        System.out.println(midi.history());
        midi.clearHistory();

        pm.beginNote(new Pitch(0));
        Midi.rest(50);
        pm.endNote(new Pitch(2));
        // System.out.println("PASDAS");
        System.out.println(midi.history());
        midi.clearHistory();
        */

        pm.beginNote(new Pitch(0));
        pm.beginNote(new Pitch(2));
        Midi.rest(50);
        pm.endNote(new Pitch(0));
        pm.endNote(new Pitch(2));

        System.out.println(midi.history());
        midi.clearHistory();
    }
}
