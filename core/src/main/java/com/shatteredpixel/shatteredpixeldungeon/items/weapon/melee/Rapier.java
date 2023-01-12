/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.PathFinder;

public class Rapier extends MeleeWeapon {

	{
		image = ItemSpriteSheet.RAPIER;
		hitSound = Assets.Sounds.HIT_SLASH;
		hitSoundPitch = 1.3f;

		tier = 1;

		bones = false;
	}

	@Override
	public int max(int lvl) {
		return  4*(tier+1) +    //8 base, down from 10
				lvl*(tier+1);   //scaling unchanged
	}

	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		if (target == null){
			return;
		}

		Char enemy = Actor.findChar(target);
		if (enemy == null || enemy == hero || hero.isCharmedBy(enemy) || !Dungeon.level.heroFOV[target]){
			GLog.w(Messages.get(this, "ability_no_target"));
			return;
		}

		if (Dungeon.level.distance(hero.pos, enemy.pos) != 2){
			GLog.w(Messages.get(this, "ability_bad_position"));
			return;
		}

		int lungeCell = -1;
		for (int i : PathFinder.NEIGHBOURS8){
			if (Dungeon.level.adjacent(hero.pos + i, enemy.pos)
					&& Actor.findChar(hero.pos+i) == null
					&& Dungeon.level.passable[hero.pos+i]){
				if (lungeCell == -1 || Dungeon.level.trueDistance(hero.pos + i, enemy.pos) < Dungeon.level.trueDistance(lungeCell, enemy.pos)){
					lungeCell = hero.pos + i;
				}
			}
		}

		if (lungeCell == -1){
			GLog.w(Messages.get(this, "ability_bad_position"));
			return;
		}

		final int dest = lungeCell;
		hero.busy();
		Sample.INSTANCE.play(Assets.Sounds.MISS);
		hero.sprite.jump(hero.pos, dest, 0, 0.1f, new Callback() {
			@Override
			public void call() {
				hero.pos = dest;
				Dungeon.level.occupyCell(hero);

				hero.sprite.attack(enemy.pos, new Callback() {
					@Override
					public void call() {
						//+3+lvl damage, equivalent to +67% damage, but more consistent
						beforeAbilityUsed(hero);
						if (hero.attack(enemy, 1f, augment.damageFactor(3 + level()), Char.INFINITE_ACCURACY)){
							Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG);
							if (!enemy.isAlive()){
								onAbilityKill(hero);
							}
						}
						hero.spendAndNext(hero.attackDelay());
						afterAbilityUsed(hero);
					}
				});
			}
		});
	}
}