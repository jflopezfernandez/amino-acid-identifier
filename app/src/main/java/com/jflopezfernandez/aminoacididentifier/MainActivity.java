package com.jflopezfernandez.aminoacididentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jflopezfernandez.aminoacididentifier.aai.AminoAcid;
import com.jflopezfernandez.aminoacididentifier.aai.NucleotideSequence;

public class MainActivity extends AppCompatActivity {

    // UI Controls
    Button buttonAdenine;
    Button buttonCytosine;
    Button buttonGuanine;
    Button buttonThymine;
    Button buttonReset;

    TextView textViewAminoAcidName;
    TextView textViewNucleotides;

    final String ADENINE = "A";
    final String CYTOSINE = "C";
    final String GUANINE = "G";
    // TODO: final String THYMINE = "T";
    final String URACIL = "U";

    NucleotideSequence currentNucleotideSequence;

    AminoAcid aminoAcid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        currentNucleotideSequence = new NucleotideSequence();
        currentNucleotideSequence.clear();

        textViewAminoAcidName = findViewById(R.id.text_view_amino_acid_name);
        textViewNucleotides = findViewById(R.id.text_view_nucleotides);

        buttonAdenine  = findViewById(R.id.button_adenine);
        buttonCytosine = findViewById(R.id.button_cytosine);
        buttonGuanine  = findViewById(R.id.button_guanine);
        buttonThymine  = findViewById(R.id.button_uracil);

        buttonAdenine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNucleotideToSequence(ADENINE);
                textViewNucleotides.setText(currentNucleotideSequence.toString());
            }
        });

        buttonCytosine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNucleotideToSequence(CYTOSINE);
                textViewNucleotides.setText(currentNucleotideSequence.toString());
            }
        });

        buttonGuanine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNucleotideToSequence(GUANINE);
                textViewNucleotides.setText(currentNucleotideSequence.toString());
            }
        });

        buttonThymine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNucleotideToSequence(URACIL);
                textViewNucleotides.setText(currentNucleotideSequence.toString());
            }
        });

        buttonReset = (Button) findViewById(R.id.button_reset);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    protected void addNucleotideToSequence(final String nucleotide) {
        // If the sequence is already three nucleotides long, reset first
        if (currentNucleotideSequence.length() == 3) {
            reset();
        }

        currentNucleotideSequence.append(nucleotide);

        // If the sequence is now three nucleotides long, initialize amino acid
        if (currentNucleotideSequence.length() == 3) {
            aminoAcid = new AminoAcid(currentNucleotideSequence);

            // TODO: Update UI with amino acid info
            textViewAminoAcidName.setText(aminoAcid.toString());
        }
    }

    protected void reset() {
        currentNucleotideSequence.clear();
        aminoAcid = null;

        // Reset UI
        textViewAminoAcidName.setText("");
        textViewNucleotides.setText(currentNucleotideSequence.toString());
    }
}
