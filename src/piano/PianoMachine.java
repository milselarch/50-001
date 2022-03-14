package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;

import java.util.ArrayList;

public class PianoMachine {
    private Midi midi;
    private ArrayList<String> playingPitches = new ArrayList<>();
    private int pitchShift = 0;
    public Instrument instrument;

    /**
     * constructor for PianoMachine.
     *
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        this.playingPitches = new ArrayList<>();
        this.instrument = Instrument.PIANO;

        try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        String strPitch = rawPitch.toString();
        int frequency = rawPitch.transpose(
            this.pitchShift * 12
        ).toMidiFrequency();
        // System.out.format("START_NOTE %s\n", strPitch);

        if (this.playingPitches.contains(strPitch)) {
            // System.out.format("START_DENY %s\n", strPitch);
            return;
        }

        // System.out.format("ADDING %d\n", frequency);
        this.playingPitches.add(strPitch);
        midi.beginNote(frequency, this.instrument);
        //TODO implement for question 1
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        String strPitch = rawPitch.toString();
        int frequency = rawPitch.transpose(
            this.pitchShift * 12
        ).toMidiFrequency();

        if (!this.playingPitches.contains(strPitch)) {
            // System.out.format("NOT IN %d\n", frequency);
            return;
        }
        // System.out.format("REMOVING %d\n", frequency);
        this.playingPitches.remove(strPitch);
        midi.endNote(frequency, this.instrument);
        //TODO implement for question 1
    }

    //TODO write method spec
    public void changeInstrument() {
        Instrument[] instruments = Instrument.values();
        int index = 0;

        for (int k=0; k<instruments.length; k++) {
            if (instruments[k] == this.instrument) {
                index = k;
                break;
            }
        }

        final int new_index;
        if (index == instruments.length - 1) { new_index = 0; }
        else { new_index = index + 1; }

        this.instrument = instruments[new_index];
        //TODO: implement for question 2
    }

    //TODO write method spec
    public void shiftUp() {
        //TODO: implement for question 3
        if (this.pitchShift < 2) {
            this.pitchShift += 1;
        }
    }

    //TODO write method spec
    public void shiftDown() {
        //TODO: implement for question 3
        if (this.pitchShift > -2) {
            this.pitchShift -= 1;
        }
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
