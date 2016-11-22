package is.monkeydrivers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class Bus_ {

    private Bus bus;

    @Before
    public void setUp() throws Exception {
        bus = new ListBus();

    }

    @Test
    public void should_send_messages_to_a_subscriber() throws Exception {
        Subscriber subscriber = mock(Subscriber.class);
        bus.subscribe(subscriber);
        bus.send(new Message() {});
        bus.send(new Message() {});
        bus.send(new Message() {});
        verify(subscriber, times(3)).receive(any());
    }

    @Test
    public void should_send_message_to_all_subscribers() throws Exception {
        Subscriber subscriber1 = mock(Subscriber.class);
        Subscriber subscriber2 = mock(Subscriber.class);
        bus.subscribe(subscriber1);
        bus.subscribe(subscriber2);

        Message message = new Message() {};
        bus.send(message);
        verify(subscriber1).receive(message);
        verify(subscriber2).receive(message);
    }

}
