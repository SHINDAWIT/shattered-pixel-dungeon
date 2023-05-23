package com.shatteredpixel.shatteredpixeldungeon.actors.blobs;

import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;

public class Nature extends Blob{
    protected void clearFireFreeze(Fire fire, Freezing freeze, int cell) {
        if (fire != null)   fire.clear(cell);
        if (freeze != null) freeze.clear(cell);
    }

    public String tileDesc() {
        return Messages.get(this, "desc");
    }
}
