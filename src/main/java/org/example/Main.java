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
//        ticketService.createTicket(
//                new Client(),
//                planet,
//                planet1);

        //DELETE
//        ticketService.deleteById(1L);

        //UPDATE
        ticketService.updateById(9L,"Yan", "Mars", "Venera");


        //GETALL
//        System.out.println("ticketService.getAll() = " + ticketService.getAll());
    }
}