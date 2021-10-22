package top.ycshang.chatui.view.chat;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 22:20
 **/
public class ChatEventDefine {
    private final ChatInit chatInit;
    //private final IChatEvent iChatEvent;
    //private final IChatMethod iChatMethod;

    public ChatEventDefine(ChatInit chatInit) {
        this.chatInit = chatInit;
        //this.iChatEvent = iChatEvent;
        //this.iChatMethod = iChatMethod;

        chatInit.move();
        barChat();
        barFriend();
    }

    private void switchBarChat(Button barChat, Pane groupBarChat, boolean toggle) {
        groupBarChat.setVisible(toggle);
    }

    private void switchBarFriend(Button barFriend, Pane groupBarFriend, boolean toggle) {
        groupBarFriend.setVisible(toggle);
    }

    private void barChat() {
        Button barChat = chatInit.$("barChat", Button.class);
        Pane groupBarChat = chatInit.$("groupBarChat", Pane.class);
        barChat.setOnAction(event -> {
            switchBarChat(barChat, groupBarChat, true);
            switchBarFriend(chatInit.$("barFriend", Button.class), chatInit.$("groupBarFriend", Pane.class), false);
        });
    }

    private void barFriend() {
        Button barFriend = chatInit.$("barFriend", Button.class);
        Pane groupBarFriend = chatInit.$("groupBarFriend", Pane.class);
        barFriend.setOnAction(event -> {
                    switchBarChat(chatInit.$("barChat", Button.class), chatInit.$("groupBarChat", Pane.class), false);
                    switchBarFriend(barFriend, groupBarFriend, true);
                }
        );
    }

}