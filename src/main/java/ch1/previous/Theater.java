package ch1.previous;

import lombok.Value;

@Value
public class Theater {
    TicketSeller ticketSeller;

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            final Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            final Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().minusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
