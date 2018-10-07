package com.solid.msc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DrawableComponentFactory {
    public static DrawableComponent getDrawableComponent(Class<?> drawableComponentType) {
        DrawableComponent drawableComponent = null;
        try {
            Constructor<?> constructor = drawableComponentType.getConstructor();
            drawableComponent = (DrawableComponent) constructor.newInstance(new Object[]{});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return drawableComponent;
    }
}
