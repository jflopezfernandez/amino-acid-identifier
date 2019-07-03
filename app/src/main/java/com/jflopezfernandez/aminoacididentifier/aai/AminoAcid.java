package com.jflopezfernandez.aminoacididentifier.aai;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AminoAcid {

    private static final String ALANINE = "Alanine";
    private static final String ARGININE = "Arginine";
    private static final String ASPARAGINE = "Asparagine";
    private static final String ASPARTIC_ACID = "Aspartic Acid";
    private static final String CYSTEINE = "Cysteine";
    private static final String GLUTAMIC_ACID = "Glutamic Acid";
    private static final String GLUTAMINE = "Glutamine";
    private static final String GLYCINE = "Glycine";
    private static final String HISTIDINE = "Histidine";
    private static final String ISOLEUCINE = "Isoleucine";
    private static final String LEUCINE = "Leucine";
    private static final String LYSINE = "Lysine";
    private static final String METHIONINE = "Methionine";
    private static final String PHENYLALANINE = "Phenylalanine";
    private static final String PROLINE = "Proline";
    private static final String SERINE = "Serine";
    private static final String THREONINE = "Threonine";
    private static final String TRYPTOPHAN = "Tryptophan";
    private static final String TYROSINE = "Tyrosine";
    private static final String VALINE = "Valine";
    private static final String STOP_CODON = "Stop Codon";

    private static final Map<String, String> aminoAcidSequences;
    static {
        Map<String, String> sequenceMap = new HashMap<String, String>();

        sequenceMap.put("GCU", ALANINE);
        sequenceMap.put("GCC", ALANINE);
        sequenceMap.put("GCA", ALANINE);
        sequenceMap.put("GCG", ALANINE);
        sequenceMap.put("CGU", ARGININE);
        sequenceMap.put("CGC", ARGININE);
        sequenceMap.put("CGA", ARGININE);
        sequenceMap.put("CGG", ARGININE);
        sequenceMap.put("AGA", ARGININE);
        sequenceMap.put("AGG", ARGININE);
        sequenceMap.put("AAU", ASPARAGINE);
        sequenceMap.put("AAC", ASPARAGINE);
        sequenceMap.put("GAU", ASPARTIC_ACID);
        sequenceMap.put("GAC", ASPARTIC_ACID);
        sequenceMap.put("UGU", CYSTEINE);
        sequenceMap.put("UGC", CYSTEINE);
        sequenceMap.put("GAA", GLUTAMIC_ACID);
        sequenceMap.put("GAG", GLUTAMIC_ACID);
        sequenceMap.put("CAA", GLUTAMINE);
        sequenceMap.put("CAG", GLUTAMINE);
        sequenceMap.put("GGU", GLYCINE);
        sequenceMap.put("GGC", GLYCINE);
        sequenceMap.put("GGA", GLYCINE);
        sequenceMap.put("GGG", GLYCINE);
        sequenceMap.put("CAU", HISTIDINE);
        sequenceMap.put("CAC", HISTIDINE);
        sequenceMap.put("AUU", ISOLEUCINE);
        sequenceMap.put("AUC", ISOLEUCINE);
        sequenceMap.put("AUA", ISOLEUCINE);
        sequenceMap.put("UUA", LEUCINE);
        sequenceMap.put("UUG", LEUCINE);
        sequenceMap.put("CUU", LEUCINE);
        sequenceMap.put("CUC", LEUCINE);
        sequenceMap.put("CUA", LEUCINE);
        sequenceMap.put("CUG", LEUCINE);
        sequenceMap.put("AAA", LYSINE);
        sequenceMap.put("AAG", LYSINE);
        sequenceMap.put("AUG", METHIONINE);
        sequenceMap.put("UUU", PHENYLALANINE);
        sequenceMap.put("UUC", PHENYLALANINE);
        sequenceMap.put("CCU", PROLINE);
        sequenceMap.put("CCC", PROLINE);
        sequenceMap.put("CCA", PROLINE);
        sequenceMap.put("CCG", PROLINE);
        sequenceMap.put("UCU", SERINE);
        sequenceMap.put("UCC", SERINE);
        sequenceMap.put("UCA", SERINE);
        sequenceMap.put("UCG", SERINE);
        sequenceMap.put("AGU", SERINE);
        sequenceMap.put("AGC", SERINE);
        sequenceMap.put("ACU", THREONINE);
        sequenceMap.put("ACC", THREONINE);
        sequenceMap.put("ACA", THREONINE);
        sequenceMap.put("ACG", THREONINE);
        sequenceMap.put("UGG", TRYPTOPHAN);
        sequenceMap.put("UAU", TYROSINE);
        sequenceMap.put("UAC", TYROSINE);
        sequenceMap.put("GUU", VALINE);
        sequenceMap.put("GUC", VALINE);
        sequenceMap.put("GUA", VALINE);
        sequenceMap.put("GUG", VALINE);
        sequenceMap.put("UAA", STOP_CODON);
        sequenceMap.put("UAG", STOP_CODON);
        sequenceMap.put("UGA", STOP_CODON);

        aminoAcidSequences = Collections.unmodifiableMap(sequenceMap);
    }

    private String name;

    private NucleotideSequence nucleotides;

    public AminoAcid(NucleotideSequence sequence) {
        name = getName(sequence);
    }

    private String getName(NucleotideSequence nucleotideSequence) {
        // Make sure sequence is exactly three monomers long
        if (nucleotideSequence.length() != 3) {
            // TODO: Throw error
            return "Invalid Sequence Length";
        }

        return aminoAcidSequences.get(nucleotideSequence.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
