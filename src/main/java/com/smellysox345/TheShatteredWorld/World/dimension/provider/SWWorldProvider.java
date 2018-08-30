package com.smellysox345.TheShatteredWorld.World.dimension.provider;

import javax.annotation.Nullable;

import com.smellysox345.TheShatteredWorld.World.dimension.library.ChunkGeneratorSW;
import com.smellysox345.TheShatteredWorld.World.dimension.library.ChunkGeneratorShatteredWorld;
import com.smellysox345.TheShatteredWorld.World.dimension.shattered.ShatteredWorld;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import com.smellysox345.TheShatteredWorld.init.DimensionInit;

import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.MusicTicker.MusicType;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import smellysox345.lib.Config;

public class SWWorldProvider extends WorldProviderSurface {

	 private final float[] colorsSunriseSunset = new float[4];
	
	@Override
	public void init() {
		biomeProvider = new SWBiomeProvider(world.getSeed(), world.getWorldInfo().getTerrainType());
		setDimension(Config.ShatteredWorldDimId);
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorShatteredWorld(this.world, this.world.getSeed() - 14175);
	}
	
	
	
	@Nullable
	@Override
	@SideOnly(Side.CLIENT)
	public MusicTicker.MusicType getMusicType() {
		return MusicType.END_BOSS;
	}
	
	@Override
	@Nullable
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks)
    {
        float f = 0.4F;
        float f1 = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) - 0.0F;
        float f2 = -0.0F;

        if (f1 >= -0.4F && f1 <= 0.4F)
        {
            float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F;
            float f4 = 1.0F - (1.0F - MathHelper.sin(f3 * (float)Math.PI)) * 0.99F;
            f4 = f4 * f4;
            this.colorsSunriseSunset[0] = f3 * 0.3F + 0.7F * -0.1F;
            this.colorsSunriseSunset[1] = f3;
            this.colorsSunriseSunset[2] = f3 * f3;
            this.colorsSunriseSunset[3] = f4;
            return this.colorsSunriseSunset;
        }
        else
        {
            return null;
        }
    }
	
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.1F;

		for (int i = 0; i <= 15; i++) {
			float f1 = 1F - i / 15F;
			lightBrightnessTable[i] = (1F - f1) / (f1 * 3F + 1F) * (1F - f) + f;
		}
	}
	
	int time = 0;
	protected void keepTimeMoving() {
		
		
		if(time == 0) {
			time++;
			if(time == 1) {
				time++;
			}
		}
	}

	@Override
	public Vec3d getFogColor(float f, float f1) {
		float bright = MathHelper.cos(0.25f * 3.141593F * 2.0F) * 2.0F + 0.5F;
		if (bright < 0.0F) {
			bright = 0.0F;
		}
		if (bright > 1.0F) {
			bright = 1.0F;
		}
		float red = 0.7529412F;
		float green = 1.0F;
		float blue = 0.8470588F;
		red *= bright * 0.94F + 0.06F;
		green *= bright * 0.94F + 0.06F;
		blue *= bright * 0.91F + 0.09F;
		return new Vec3d(red, green, blue);
	}

	// Pin the celestial angle at night/evening so things that use it see night
	public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        int i = (int)(worldTime % 24000L);
        float f = ((float)i + partialTicks) / 24000.0F - 0.25F;

        if (f < 0.0F)
        {
            ++f;
        }

        if (f > 1.0F)
        {
            --f;
        }

        float f1 = 1.0F - (float)((Math.cos((double)f * Math.PI) + 1.0D) / 2.0D);
        f = f + (f1 - f) / 3.0F;
        return f;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean isSkyColored() {
		return false;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 30;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
		// TODO Maybe in the future we can get the return of sky color by biome?
		return new Vec3d(32 / 256.0, 34 / 256.0, 74 / 256.0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		return 2.0F;
	}

	@Override
	public double getHorizon() {
		return ShatteredWorld.SEALEVEL;
	}
	
	@Override
	public DimensionType getDimensionType() {

		return DimensionInit.SW;
	}
}
