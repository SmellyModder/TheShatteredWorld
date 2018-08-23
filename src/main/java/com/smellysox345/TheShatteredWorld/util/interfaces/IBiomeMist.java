package com.smellysox345.TheShatteredWorld.util.interfaces;

public interface IBiomeMist {
		   /**
		    * Set the density/how much mist there should be in the biome.
		    * @return 0 to have no mist at all.
		    */
		   float getMistDensity(int var1, int var2, int var3);

		   /**
		    * Sets the color of the mist. Uses decimal values for color.
		    * @return 0 for black mist.
		    */
		   int getMistColor(int var1, int var2, int var3);

		   /**
		    * This is only used by some mods and can be considered as optional.
		    * Sets the multiplier used by other mist mods like Mist Power, is used for randomizing integers.
		    * @return 0 for no multiplier, not recommended as it will still be used by mods requesting it!
		    */
		   int getMistMultiplier(int var1);
}
