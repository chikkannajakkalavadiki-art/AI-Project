package com.example.smart_support_ai.controller;



import org.springframework.web.bind.annotation.*;

import com.example.smart_support_ai.entity.Ticket;
import com.example.smart_support_ai.repository.TicketRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {

        System.out.println("Creating ticket: " + ticket.getTitle());

        ticket.setStatus("OPEN");

        return ticketRepository.save(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {

        return ticketRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {

        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
    
    @PutMapping("/{id}")
    public Ticket updateTicket(
            @PathVariable Long id,
            @RequestBody Ticket updatedTicket) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setTitle(updatedTicket.getTitle());
        ticket.setDescription(updatedTicket.getDescription());
        ticket.setCategory(updatedTicket.getCategory());
        ticket.setPriority(updatedTicket.getPriority());
        ticket.setStatus(updatedTicket.getStatus());

        return ticketRepository.save(ticket);
    }
}	
