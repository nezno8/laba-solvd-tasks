package com.solvd.laba.tamagotchi;

import java.util.Locale;

public enum BodyCovering {
    FUR("Fur"),
    FEATHERS("Feathers"),
    SCALES("Scales"),
    SKIN("Skin");

    private final String description;

    BodyCovering(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description.toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return description;
    }
}
