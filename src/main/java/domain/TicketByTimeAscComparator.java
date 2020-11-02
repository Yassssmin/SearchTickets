package domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<InfoTicket> {
    @Override
    public int compare(InfoTicket o1, InfoTicket o2) {
        return o1.getTime() - o2.getTime();
    }
}
