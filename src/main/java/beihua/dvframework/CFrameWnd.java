package beihua.dvframework;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class CFrameWnd extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CFrameWnd(){
        super();
        setSize(850,410);
        this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
    }
}