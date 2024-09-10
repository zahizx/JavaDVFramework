package beihua.dvframework;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CWinApp {
    CCmdTarget m_cct = new CCmdTarget();
    CFrameWnd m_cfw = new CFrameWnd();

    CView[] m_cv;
    CDocument m_cdoc;

    public void InitializeInstance(String documentClassName, String[] ViewClassNames, JMenuBar menu) {

        for (int i = 0; i < menu.getMenuCount(); i++) {
            JMenu jm = menu.getMenu(i);
            for (int j = 0; j < jm.getItemCount(); j++) {
                jm.getItem(j).addActionListener(m_cct);
            }
        }
        Class cd = null;
        try {
            cd = Class.forName(documentClassName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            m_cdoc = (CDocument) cd.newInstance();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        m_cct.registerHandler(m_cdoc);

        Class cv = null;
        m_cv = new CView[ViewClassNames.length];
        for (int indexview = 0; indexview < ViewClassNames.length; indexview++) {
            try {
                cv = Class.forName(ViewClassNames[indexview]);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                m_cv[indexview] = (CView) cv.newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            m_cv[indexview].setPreferredSize(new Dimension(400, 300));
            m_cv[indexview].setBorder(BorderFactory.createLineBorder(Color.red));


            m_cfw.add(m_cv[indexview]);

            m_cct.registerHandler(m_cv[indexview]);

            m_cdoc.registerView(m_cv[indexview]);
        }

        m_cfw.setJMenuBar(menu);
        m_cfw.pack();
        m_cfw.setVisible(true);
    }

    public static void main(String[] args) {

        JMenuBar jmb = new JMenuBar();
        JMenu jm = new JMenu("student");
        JMenuItem jmi1 = new JMenuItem("add");
        JMenuItem jmi2 = new JMenuItem("delete");
        jm.add(jmi1);
        jm.add(jmi2);
        jmb.add(jm);

        CWinApp cwa = new CWinApp();
        String[] views = {"beihua.dvframework.CView", "beihua.dvframework.CView"};
        cwa.InitializeInstance("beihua.dvframework.CDocument", views, jmb);

  /*CFrameWnd cfw=new CFrameWnd();
  cfw.setSize(800,400);
  cfw.setLocationRelativeTo(null);
  cfw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  cfw.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
  CView cw1=new CView();
  CView cw2=new CView();
  cw1.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
  cw2.setLayout(new FlowLayout(FlowLayout.LEFT,50,60));
  JButton but1=new JButton("test1");
  JButton but2=new JButton("test2");
  JButton but3=new JButton("test3");
  cw2.add(but1);cw2.add(but3);
  cw1.add(but2);cw1.add(but3);
  cfw.add(cw1);
  cfw.add(cw2);
  cfw.setVisible(true);*/

    }

}
