package blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertkurnia on 7/24/2017.
 */
@Service()
public class NotificationServiceImpl implements NotificationService{

    public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessages";

    @Autowired
    private HttpSession httpSession;

    @Override
    public void addInfoMessage(String msg) {
        addNotificationMessage(NotificationMessageType.INFO, msg);
    }

    public void addErrorMessage(String msg) {
        addNotificationMessage(NotificationMessageType.ERROR,msg);
    }

    private enum NotificationMessageType {
        INFO,
        ERROR,
    }

    private void addNotificationMessage(NotificationMessageType type, String msg) {
        List<NotificationMessage> notifyMessages = (List<NotificationMessage>)
                httpSession.getAttribute(NOTIFY_MSG_SESSION_KEY);
        if(notifyMessages == null) {
            notifyMessages = new ArrayList<NotificationMessage>();
        }
        notifyMessages.add(new NotificationMessage(type,msg));
        httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);
    }

    public class NotificationMessage {
        NotificationMessageType type;
        String text;

        public NotificationMessage(NotificationMessageType type, String text) {
            this.text = text;
            this.type = type;
        }

        public NotificationMessageType getType() {
            return type;
        }

        public String getText(){
            return text;
        }
    }
}
