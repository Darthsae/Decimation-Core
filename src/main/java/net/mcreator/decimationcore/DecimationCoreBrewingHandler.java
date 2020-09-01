/**
 * This mod element is always locked. Enter your code in the methods below.
 * If you don't need some of these methods, you can remove them as they
 * are overrides of the base class DecimationCoreModElements.ModElement.
 *
 * You can register new events in this class too.
 *
 * As this class is loaded into mod element list, it NEEDS to extend
 * ModElement class. If you remove this extend statement or remove the
 * constructor, the compilation will fail.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser - New... and make sure to make the class
 * outside net.mcreator.decimationcore as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
*/
package net.mcreator.decimationcore;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@DecimationCoreModElements.ModElement.Tag
public class DecimationCoreBrewingHandler extends DecimationCoreModElements.ModElement {
	/**
	 * Do not remove this constructor
	 */
	public DecimationCoreBrewingHandler(DecimationCoreModElements instance) {
		super(instance, 2);
	}


	@Override
	public void init(FMLCommonSetupEvent event) {
	try {
    	Class clazz = net.minecraft.potion.PotionBrewing.class;
    	Method mth = ObfuscationReflectionHelper.findMethod(clazz, "func_193357_a", Potion.class, 
		Item.class, Potion.class);
    	mth.invoke(null, basePotion, ingredient, resultPotion);
    	// To add more recipes, you can copy the line above, for ex.
    	// mth.invoke(null, potion2, item2, potion3);
	}catch (Throwable e) {
    	System.err.println("ERROR: " + e); // You can change this part
}
	}
	
}
