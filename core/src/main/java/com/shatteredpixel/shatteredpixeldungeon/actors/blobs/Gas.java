package com.shatteredpixel.shatteredpixeldungeon.actors.blobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.effects.BlobEmitter;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;

public abstract class Gas extends Blob {
	@Override
	protected void evolve() {
		super.evolve();
		
		Char ch;
		int cell;
		
		for (int i = area.left; i < area.right; i++) {
			for (int j = area.top; j < area.bottom; j++) {
				cell = i + j * Dungeon.level.width();
				if (cur[cell] > 0 && (ch = Actor.findChar(cell)) != null) {
					if (!ch.isImmune(this.getClass()))
						Gas_evolve(ch);
				}
			}
		}
	}

	@Override
	public String tileDesc() {
		return Messages.get(this, "desc");
	}
	
	@Override
	public void use( BlobEmitter emitter ) {
		super.use( emitter );
		
		Use_emitter(emitter);
	}

	protected abstract void Gas_evolve(Char ch);
	protected abstract void Use_emitter(BlobEmitter emitter);
}