package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InfoTicket implements Comparable {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int time;    //minutes

    @Override
    public int compareTo(Object o) {
        InfoTicket compareTicket = (InfoTicket) o;

        return cost - compareTicket.cost;
    }
}
