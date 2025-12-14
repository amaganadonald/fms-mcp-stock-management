package com.amagana.fms_ai_server.enums;

public enum Units {

    KG("kg"),
    COIN("silver coin"),
    LITRE("litre");

    final String unit_name;

    Units(String unit_name) {
        this.unit_name = unit_name;
    }
}
