package com.himanshu.frameworkdemo.helpers;

import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * @author Himanshu Patel
 */
public class FontsOverride {

    public static void setDefaultFont(String staticTypefaceFieldName) {
        Typeface regular = Typeface.create("sans-serif-light", Typeface.NORMAL);
        replaceFont(staticTypefaceFieldName, regular);
    }

//    public static void setDefaultFont(Context context, String staticTypefaceFieldName, String fontAssetName) {
//        final Typeface regular = Typeface.createFromAsset(context.getAssets(), fontAssetName);
//        replaceFont(staticTypefaceFieldName, regular);
//    }

    private static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
        try {
            Field staticField = Typeface.class.getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
