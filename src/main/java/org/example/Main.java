package org.example;

import org.example.dto.Client;
import org.example.dto.Planet;
import org.example.migration.FlywayMigration;
import org.example.service.TicketService;

public class Main {
    public static void main(String[] args) {
        new FlywayMigration().migration();
        TicketService ticketService = new TicketService();
        //CREATE
//        Planet planet = new Planet();
//        planet.setId("MERCURY");
//        planet.setName("Mercury");
//        Planet planet1 = new Planet();
//        planet1.setId("MARS");
//        planet1.setName("Mars");
//        ticketService.createTicket(
//                new Client("Vasil"),
//                planet,
//                planet1);

        //DELETE
//        ticketService.deleteById(1L);

        //UPDATE
//        Client client = new Client();
//        Planet toPlanet = new Planet();
//        Planet fromPlanet = new Planet();
//        client.setName("Killlll");
//        toPlanet.setId("MERCURY");
//        toPlanet.setName("Mercury");
//        fromPlanet.setName("Mars");
//        fromPlanet.setId("MARS");
//        ticketService.updateById(11L,client, toPlanet, fromPlanet);


        //GETALL
//        System.out.println("ticketService.getAll() = " + ticketService.getAll());
    }
}