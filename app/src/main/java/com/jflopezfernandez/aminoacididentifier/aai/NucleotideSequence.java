package com.jflopezfernandez.aminoacididentifier.aai;

import androidx.annotation.NonNull;

public class NucleotideSequence {
    private String sequence;

    public NucleotideSequence() {
        // Initialize with empty sequence
        clear();
    }

    public NucleotideSequence(@NonNull final String nucleotideSequence) {
        sequence = nucleotideSequence;
    }

    public void clear() {
        sequence = "";
    }

    public void append(final String nucleotide) {
        sequence += nucleotide;
    }

    public int length() {
        return sequence.length();
    }

    public boolean sameLength(NucleotideSequence nucleotideSequence) {
        return (this.length() == nucleotideSequence.length());
    }

    public boolean equals(NucleotideSequence otherSequence) {
        if (!sameLength(otherSequence)) return false;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) != otherSequence.sequence.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return sequence;
    }
}
