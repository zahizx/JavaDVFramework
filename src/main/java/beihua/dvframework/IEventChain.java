package beihua.dvframework;

import java.awt.event.ActionEvent;

public interface IEventChain {
    public boolean processEvent(ActionEvent e);
}