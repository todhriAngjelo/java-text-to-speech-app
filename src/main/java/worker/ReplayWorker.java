package worker;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ReplayWorker {

    private static ReplayWorker INSTANCE;
    private static List<ActionListener> savedListeners = new ArrayList<>();

    public static ReplayWorker getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ReplayWorker();
        }

        return INSTANCE;
    }

    public void replay() {
        int s = savedListeners.size();
        for (int i = 0; i < s; i++) {
            savedListeners.get(i).actionPerformed(null);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < savedListeners.size()/2; i++) {
            savedListeners.remove(0);
        }
    }

    public void reset() {
        savedListeners.clear();
    }

    public void add(ActionListener cm) {
        savedListeners.add(cm);
    }
}
