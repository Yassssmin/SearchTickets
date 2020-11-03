package domain;

import java.util.Comparator;

public class TicketByFlightTimeAscComparator implements Comparator<InfoTicket> {
    @Override
    public int compare(InfoTicket o1, InfoTicket o2) {
        return o1.getFlightTime().compareTo(o2.getFlightTime());
    }
}
