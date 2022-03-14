package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;

import java.util.ArrayList;

public class PianoMachine {
    private Midi midi;
    private final ArrayList<String> playingPitches;

    /**
     * constructor for PianoMachine.
     *
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        this.playingPitches = new ArrayList<>();

        try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        int frequency = rawPitch.toMidiFrequency();
        String strPitch = rawPitch.toString();
        // System.out.format("START_NOTE %s\n", strPitch);

        if (this.playingPitches.contains(strPitch)) {
            // System.out.format("START_DENY %s\n", strPitch);
            return;
        }

        // System.out.format("ADDING %d\n", frequency);
        this.playingPitches.add(strPitch);
        midi.beginNote(frequency);
        //TODO implement for question 1
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        int frequency = rawPitch.toMidiFrequency();
        String strPitch = rawPitch.toString();

        if (!this.playingPitches.contains(strPitch)) {
            // System.out.format("NOT IN %d\n", frequency);
            return;
        }
        // System.out.format("REMOVING %d\n", frequency);
        this.playingPitches.remove(strPitch);
        midi.endNote(frequency);
        //TODO implement for question 1
    }

    //TODO write method spec
    public void changeInstrument() {
        //TODO: implement for question 2
    }

    //TODO write method spec
    public void shiftUp() {
        //TODO: implement for question 3
    }

    //TODO write method spec
    public void shiftDown() {
        //TODO: implement for question 3
    }

    //TODO write method spec
    public boolean toggleRecording() {
        return false;
        //TODO: implement for question 4
    }

    //TODO write method spec
    public void playback() {
        //TODO: implement for question 4
    }

}
