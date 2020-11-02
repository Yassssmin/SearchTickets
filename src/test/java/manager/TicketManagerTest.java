package manager;

import domain.InfoTicket;
import domain.TicketByTimeAscComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private InfoTicket firstTicket;
    private InfoTicket secondTicket;
    private InfoTicket thirdTicket;
    private InfoTicket fourthTicket;
    private InfoTicket fifthTicket;
    private InfoTicket sixthTicket;
    private InfoTicket seventhTicket;
    private InfoTicket eighthTicket;

    private TicketRepository repository;
    private TicketManager manager;

    private Comparator<InfoTicket> comparator;

    @BeforeEach
    void setUp() {
        firstTicket = new InfoTicket(1, 245, "DME", "EGO", 180);
        secondTicket = new InfoTicket(2, 4587, "DME", "EGO", 400);
        thirdTicket = new InfoTicket(3, 2176, "ABG", "EGO", 600);
        fourthTicket = new InfoTicket(4, 1000, "DME", "EGO", 160);
        fifthTicket = new InfoTicket(5, 10000, "ABR", "EGO", 180);
        sixthTicket = new InfoTicket(6, 50576, "EGO", "ABR", 180);
        seventhTicket = new InfoTicket(7, 100, "DME", "EGO", 60);
        eighthTicket = new InfoTicket(8, 10, "EGO", "ABR", 80);

        repository = new TicketRepository();
        manager = new TicketManager(repository);

        repository.save(firstTicket);
        repository.save(secondTicket);
        repository.save(thirdTicket);
        repository.save(fourthTicket);
        repository.save(fifthTicket);
        repository.save(sixthTicket);
        repository.save(seventhTicket);
        repository.save(eighthTicket);

        comparator = new TicketByTimeAscComparator();
    }

    @Test
    void shouldFindAllByFromAndTo() {
        InfoTicket[] expected = new InfoTicket[]{seventhTicket, firstTicket, fourthTicket, secondTicket};
        InfoTicket[] actual = manager.findAll("DME", "EGO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithOneElement() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        InfoTicket ticket = new InfoTicket(3, 2176, "ABG", "EGO", 180);

        repository.save(ticket);

        InfoTicket[] expected = new InfoTicket[]{ticket};
        InfoTicket[] actual = manager.findAll("ABG", "EGO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithEmptyRepository() {
        TicketRepository emptyRepository = new TicketRepository();
        TicketManager manager = new TicketManager(emptyRepository);

        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("TST", "TST");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithWrongFrom() {
        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("MMR", "EGO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithWrongTo() {
        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("EGO", "MMR");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToSortByTime() {
        InfoTicket[] expected = new InfoTicket[]{seventhTicket, fourthTicket, firstTicket, secondTicket};
        InfoTicket[] actual = manager.findAll("DME", "EGO", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithOneElementSortByTime() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        InfoTicket ticket = new InfoTicket(3, 2176, "ABG", "EGO", 180);

        repository.save(ticket);

        InfoTicket[] expected = new InfoTicket[]{ticket};
        InfoTicket[] actual = manager.findAll("ABG", "EGO", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithEmptyRepositorySortByTime() {
        TicketRepository emptyRepository = new TicketRepository();
        TicketManager manager = new TicketManager(emptyRepository);

        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("TST", "TST", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithWrongFromSortByTime() {
        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("MMR", "EGO", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllByFromAndToWithWrongToSortByTime() {
        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("EGO", "MMR",comparator);

        assertArrayEquals(expected, actual);
    }
}