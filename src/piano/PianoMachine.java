package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;

import java.util.ArrayList;
import java.util.HashMap;

public class PianoMachine {
    private Midi midi;
    private ArrayList<String> playingPitches = new ArrayList<>();
    private int pitchShift = 0;
    public Instrument instrument;

    private final ArrayList<NoteEvent> recording = new ArrayList<>();
    private Long lastStamp = 0L;
    private boolean isRecording = false;

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

    public long newTimePassed() {
        long stampNow = System.currentTimeMillis();
        if (lastStamp == -1L) {
            lastStamp = stampNow;
        }

        long timePassed = stampNow - lastStamp;
        this.lastStamp = stampNow;
        return timePassed;
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        String strPitch = rawPitch.toString();
        Pitch adjustedPitch = rawPitch.transpose(this.pitchShift * 12);
        int frequency = adjustedPitch.toMidiFrequency();
        // System.out.format("START_NOTE %s\n", strPitch);

        if (this.playingPitches.contains(strPitch)) {
            // System.out.format("START_DENY %s\n", strPitch);
            return;
        }

        // System.out.format("ADDING %d\n", frequency);
        this.playingPitches.add(strPitch);
        midi.beginNote(frequency, this.instrument);
        //TODO implement for question 1

        if (isRecording) {
            recording.add(new NoteEvent(
                adjustedPitch, this.newTimePassed(), this.instrument,
                NoteEvent.Kind.start
            ));
        }
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        String strPitch = rawPitch.toString();
        Pitch adjustedPitch = rawPitch.transpose(this.pitchShift * 12);
        int frequency = adjustedPitch.toMidiFrequency();

        if (!this.playingPitches.contains(strPitch)) {
            // System.out.format("NOT IN %d\n", frequency);
            return;
        }
        // System.out.format("REMOVING %d\n", frequency);
        this.playingPitches.remove(strPitch);
        midi.endNote(frequency, this.instrument);
        //TODO implement for question 1

        if (isRecording) {
            recording.add(new NoteEvent(
                adjustedPitch, this.newTimePassed(), this.instrument,
                NoteEvent.Kind.stop
            ));
        }
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
        if (isRecording) {
            isRecording = false;
            // System.out.println("TOGGLE OFF");
        } else {
            this.recording.clear();
            this.lastStamp = -1L;
            isRecording = true;
        }

        return isRecording;
        //TODO: implement for question 4
    }

    //TODO write method spec
    public void playback() {
        try {
            //TODO: implement for question 4
            for (NoteEvent event : this.recording) {
                assert event.getTime() >= 0;
                long sleep = event.getTime();
                if (sleep > 0) { Thread.sleep(sleep); }

                int frequency = event.getPitch().toMidiFrequency();
                Instrument instrument = event.getInstr();

                if (event.getKind() == NoteEvent.Kind.start) {
                    midi.beginNote(frequency, instrument);
                } else {
                    midi.endNote(frequency, instrument);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("THREAD INTERRUPRTED");
        }
    }
}
