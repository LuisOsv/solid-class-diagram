package com.solid.msc;

import com.solid.msc.UmlEntities.UmlComponent;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class TransferableEntity implements Transferable {

    protected static DataFlavor dataFlavor = new DataFlavor(UmlComponent.class, "A Drawable Component");
    private UmlComponent umlComponent;

    public TransferableEntity(UmlComponent umlComponent) {
        this.umlComponent = umlComponent;
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
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (flavor.equals(dataFlavor))
            return umlComponent;
        else
            throw new UnsupportedFlavorException(flavor);
    }
}
