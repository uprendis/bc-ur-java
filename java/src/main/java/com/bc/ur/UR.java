package com.bc.ur;

import java.util.regex.Pattern;

import static com.bc.ur.URJni.UR_get_message;
import static com.bc.ur.URJni.UR_new_from_message;

public class UR {

    private static final String UR_TYPE_PATTERN = "^[a-z0-9-]+$";

    private final String type;

    private final byte[] cbor;

    public UR(String type, byte[] cbor) {
        validateType(type);
        this.type = type;
        this.cbor = cbor;
    }

    private void validateType(String type) {
        if (Pattern.compile(UR_TYPE_PATTERN).matcher(type).matches())
            return;
        throw new URException("Invalid UR type. Valid pattern is " + UR_TYPE_PATTERN);
    }

    public byte[] getCbor() {
        return cbor;
    }

    public String getType() {
        return type;
    }
}
