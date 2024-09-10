package beihua.dvframework;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

public class CCmdTarget implements ActionListener{
    List<IEventChain> DVObjects=new LinkedList<IEventChain>();
    public void actionPerformed(ActionEvent e){
        for(IEventChain iec : DVObjects){
            if(iec.processEvent(e))
                break;
        }
    }
    public void registerHandler(IEventChain iec){
        DVObjects.add(iec);
    }
}