package manager;

import domain.InfoTicket;
import repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public InfoTicket[] findAll(String from, String to) {
        InfoTicket[] allTickets = ticketRepository.getAll();
        InfoTicket[] filteredTickets = new InfoTicket[0];

        for (InfoTicket ticket : allTickets) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                int length = filteredTickets.length + 1;
                InfoTicket[] tmp = new InfoTicket[length];

                System.arraycopy(filteredTickets, 0, tmp, 0, filteredTickets.length);

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;

                filteredTickets = tmp;
            }
        }

        Arrays.sort(filteredTickets);

        return filteredTickets;
    }
}
