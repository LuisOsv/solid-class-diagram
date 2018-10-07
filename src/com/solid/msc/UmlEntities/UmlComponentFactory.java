package com.solid.msc.UmlEntities;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UmlComponentFactory {
    public static UmlComponent getDrawableComponent(Class<?> drawableComponentType) {
        UmlComponent umlComponent = null;
        try {
            Constructor<?> constructor = drawableComponentType.getConstructor();
            umlComponent = (UmlComponent) constructor.newInstance(new Object[]{});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return umlComponent;
    }
}
