package com.example.vans_back.business;

import lombok.Getter;

@Getter
public enum Status {
    SENT ("S"),
    RECEIVED ("R"),
    NEW ("N"),
    ACTIVE ("A"),
    DELETED("D");

    private final String letter;

    Status(String letter) {
        this.letter = letter;
    }
}