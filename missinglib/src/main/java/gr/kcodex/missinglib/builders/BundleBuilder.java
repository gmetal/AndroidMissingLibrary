package gr.kcodex.missinglib.builders;

import android.os.Bundle;

import java.io.Serializable;

/**
 * Helper class to quickly create a bundle in a single line
 */
public class BundleBuilder {
    private Bundle mBundle = new Bundle();

    protected BundleBuilder() {

    }

    public static BundleBuilder newBuilder() {
        return new BundleBuilder();
    }

    public Bundle create() {
        return mBundle;
    }

    public BundleBuilder putString(String key, String value) {
        mBundle.putString(key, value);
        return this;
    }

    public BundleBuilder putInt(String key, Integer value) {
        mBundle.putInt(key, value);
        return this;
    }

    public BundleBuilder putSerialisable(String key, Serializable serializable) {
        mBundle.putSerializable(key, serializable);
        return this;
    }
}
