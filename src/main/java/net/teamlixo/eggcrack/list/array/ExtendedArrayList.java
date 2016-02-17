package net.teamlixo.eggcrack.list.array;

import net.teamlixo.eggcrack.list.AbstractExtendedList;

import java.util.ArrayList;
import java.util.List;

public class ExtendedArrayList<T> extends AbstractExtendedList {
    public ExtendedArrayList(ArrayList<T> list) {
        super(list);
    }
    public ExtendedArrayList() {
        super(new ArrayList<T>());
    }
}
