package domain;

import java.time.Duration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InfoTicket implements Comparable<InfoTicket> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private Duration flightTime;

    @Override
    public int compareTo(InfoTicket compareTicket) {
        return cost - compareTicket.cost;
    }
}
