package tech.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TechRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("TechRequestListener 해제 호출");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("TechRequestListener 초기화 호출");
    }
}
