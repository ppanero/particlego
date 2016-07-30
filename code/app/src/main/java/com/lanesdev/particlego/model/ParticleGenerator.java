package com.lanesdev.particlego.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class ParticleGenerator
{
    //private static final int LONGITUDE_MAX = 180;
    //private static final int LATITUDE_MAX = 85;
    private static final double LONGITUDE_MAX = 0.001;
    private static final double LATITUDE_MAX = 0.003;
    private static final int POSSIBLE_PARTICLES_NO_CHAMBER = 3;
    private static final int POSSIBLE_PARTICLES_WITH_CHAMBER = 6;

    private static final Random r = new Random();

    public static Map<LatLng, Particle> generateParticles(final int number, final boolean hasBubbleChamber)
    {
        final Map<LatLng, Particle>  particles = new HashMap<LatLng, Particle> ();
        for (int i = 0; i < number; i++)
        {
            MapParticle particle = generateParticle(hasBubbleChamber);
            particles.put(particle.getLocation(),particle.getParticle());
        }
        return particles;
    }

    public static MapParticle generateParticle(final boolean hasBubbleChamber)
    {
        //final double longitude = r.nextDouble() * 2 * LONGITUDE_MAX - LONGITUDE_MAX;
        //final double latitude = r.nextDouble() * 2 * LATITUDE_MAX - LATITUDE_MAX;
        //final double randNum = r.nextDouble();
        final double longitude = 6.054613 + r.nextDouble() * 2 * LONGITUDE_MAX - LONGITUDE_MAX;
        final double latitude = 46.230949 + r.nextDouble() * 2 * LATITUDE_MAX - LATITUDE_MAX;
        final double randNum = r.nextDouble();

        final double possibleParticlesNumber = hasBubbleChamber ? POSSIBLE_PARTICLES_WITH_CHAMBER : POSSIBLE_PARTICLES_NO_CHAMBER;

        String name = "Electron";


        if (randNum > 1.0 / possibleParticlesNumber)
        {
            name = "Proton";
        }
        if (randNum > 2.0 / possibleParticlesNumber)
        {
            name = "Neutron";
        }
        if (randNum > 3.0 / possibleParticlesNumber)
        {
            name = "Positron";
        }
        if (randNum > 4.0 / possibleParticlesNumber)
        {
            name = "Muon";
        }
        if (randNum > 5.0 / possibleParticlesNumber)
        {
            name = "Kaon";
        }

        return new MapParticle(new Particle(name), new LatLng(latitude, longitude));
    }
}