package com.smellysox345.TheShatteredWorld.util.interfaces;

public interface IGlobalProp {

	   int getMobSpawnRate(int spawnRate);

	   /**
	    * Tell's the biome to not or do spawn mob's at night only(For dimension)
	    * 
	    */
	   boolean mobSpawnOnNight = false;
	   
	   //Used for telling the dimension to spawn mobs if this time is met?
	   int timeOfDay(int time);
}
