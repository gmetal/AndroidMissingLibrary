package gr.kcodex.missinglib.builders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;

public class IntentBuilder {
    private Intent mIntent;

    private IntentBuilder() {
        mIntent = new Intent();
    }

    public static IntentBuilder create() {
        return new IntentBuilder();
    }

    public IntentBuilder setAction(String action) {
        mIntent.setAction(action);
        return this;
    }

    public IntentBuilder setData(Uri data) {
        mIntent.setData(data);
        return this;
    }

    public IntentBuilder setClass(Context ctx, Class<?> cls) {
        mIntent.setClass(ctx, cls);
        return this;
    }

    public IntentBuilder setPackage(String pkg) {
        mIntent.setPackage(pkg);
        return this;
    }

    public IntentBuilder putExtra(String name, Parcelable value) {
        mIntent.putExtra(name, value);
        return this;
    }

    public IntentBuilder putExtra(String name, String value) {
        mIntent.putExtra(name, value);
        return this;
    }

    public IntentBuilder putExtra(String name, Boolean value) {
        mIntent.putExtra(name, value);
        return this;
    }

    public IntentBuilder putExtra(String name, Integer value) {
        mIntent.putExtra(name, value);
        return this;
    }

    public IntentBuilder putExtra(String name, Float value) {
        mIntent.putExtra(name, value);
        return this;
    }

    public IntentBuilder putExtra(String name, Double value) {
        mIntent.putExtra(name, value);
        return this;
    }

    public IntentBuilder addFlags(int flags) {
        mIntent.addFlags(flags);
        return this;
    }

    public Intent build() {
        return mIntent;
    }
}

