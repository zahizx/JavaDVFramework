package beihua.dvframework;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

public class CDocument implements IEventChain{

    List<CView> views=new LinkedList<CView>();
    public void registerView(CView cv){
        views.add(cv);
        cv.setDocument(this);
    }
    public void updateAllViews(){
        for(CView v:views){
            v.updateView();
        }
    }
    @Override
    public boolean processEvent(ActionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

}