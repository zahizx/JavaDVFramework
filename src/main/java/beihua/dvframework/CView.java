package beihua.dvframework;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class CView extends JPanel implements IEventChain {

    private static final long serialVersionUID = 1L;
    protected CDocument _document = null;

    public CView() {
        System.out.println("cview was constructed");
    }

    public void setDocument(CDocument doc) {
        _document = doc;
    }

    public void updateView() {
        this.repaint();
    }

    @Override
    public boolean processEvent(ActionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

}