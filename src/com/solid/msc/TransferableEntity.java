package com.solid.msc;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TransferableEntity implements Transferable {

    protected static DataFlavor dataFlavor = new DataFlavor(DrawableComponent.class, "A Drawable Component");
    protected static DataFlavor[] supportedFlavors = {dataFlavor};
    private DrawableComponent drawableComponent;

    public TransferableEntity(DrawableComponent drawableComponent) {
        this.drawableComponent = drawableComponent;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[0];
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(dataFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(dataFlavor))
            return drawableComponent;
        else
            throw new UnsupportedFlavorException(flavor);
    }
}
