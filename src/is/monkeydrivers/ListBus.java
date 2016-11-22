package is.monkeydrivers;

import java.util.ArrayList;
import java.util.List;

public class ListBus implements Bus {

    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void send(Message message) {
        this.subscribers.forEach(subscriber -> subscriber.receive(message));
    }
}
