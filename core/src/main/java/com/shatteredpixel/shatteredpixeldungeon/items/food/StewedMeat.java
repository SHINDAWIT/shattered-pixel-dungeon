/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2023 Evan Debenham
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

package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.items.Recipe;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class StewedMeat extends Food {

	{
		image = ItemSpriteSheet.STEWED;
		energy = Hunger.HUNGRY/2f;
	}

	@Override
	public int value() {
		return 8 * quantity;
	}

	public static class StewedMeatRecipe extends Recipe.SimpleRecipe {
		public StewedMeatRecipe(StewedMeatEnum quantity) {
			int quantityIntValue = quantity.ordinal(); // Convert enum value to int

			inputs = new Class[]{MysteryMeat.class};
			inQuantity = new int[]{quantityIntValue};

			if(quantityIntValue == 3) {
				cost = 2;
			} else {
				cost = quantityIntValue;
			}

			output = StewedMeat.class;
			outQuantity = quantityIntValue;
		}
	}
}