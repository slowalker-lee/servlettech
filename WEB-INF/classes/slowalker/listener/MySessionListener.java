package slowalker.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Iterator;
import java.util.Hashtable;

public class MySessionListener implements HttpSessionListener{

    static Hashtable<String, HttpSession> ht = new Hashtable<>();

    public void sessionCreated(HttpSessionEvent hse){
        HttpSession session = hse.getSession();
        ht.put(session.getId(), session);
        System.out.println("Session Created (MySessionListener)" + session.getId());
    }

    public void sessionDestoryed(HttpSessionEvent hse){
        HttpSession session = hse.getSession();
        System.out.println("Session Destroted (MySessionListener)" + session.getId());
        ht.remove(session.getId());
    }

    static public Iterator getSet(){
        return ht.values().iterator();
    }

    static public HttpSession getSession(String sessionId){
        return (HttpSession)ht.get(sessionId);
    }
}