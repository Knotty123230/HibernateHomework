package service;

import org.example.dto.Planet;
import org.example.service.PlanetService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlanetServiceTest {
    private PlanetService planetService;

    @Before
    public void init() {
        planetService = new PlanetService();
    }

    @Test
    public void successfulFindPlanetById() {
        Planet mars = planetService.getPlanetByID("MARS");
        Assert.assertEquals("Mars", mars.getName());
    }

    @Test
    public void unSuccessfulFindPlanetById() {
        Assert.assertThrows(Exception.class, () -> planetService.getPlanetByID("adadada"));
    }


    @Test
    public void unsuccessfulUpdateClientTest() {
        Assert.assertThrows(Exception.class, () -> planetService.updateById("LIAK", "Mercury"));
    }

    @Test
    public void unSuccessfulDeleteClientTest() {
        Assert.assertThrows(Exception.class, () -> planetService.deleteById("UDA"));
    }

    @Test
    public void createPlanetTest() {
        Session session = HibernateUtil.getConfiguration().openSession();
        planetService.createPlanet("KARS", "Kars");
        Planet planet = session.find(Planet.class, "KARS");
        Assert.assertEquals("Kars", planet.getName());
        session.close();
    }

    @Test
    public void deletePlanetTest() {
        planetService.createPlanet("KAFS", "Kars");
        planetService.deleteById("KAFS");

        Assert.assertThrows(RuntimeException.class, () -> planetService.getPlanetByID("KAFS"));
    }


}
