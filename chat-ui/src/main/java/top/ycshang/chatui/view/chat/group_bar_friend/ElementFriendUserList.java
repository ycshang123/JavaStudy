package top.ycshang.chatui.view.chat.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * 好友列表组件
 *
 * @author ycshang
 */
public class ElementFriendUserList {

    private final Pane pane;
    /**
     * 好友列表
     */
    private ListView<Pane> userListView;

    public ElementFriendUserList() {
        pane = new Pane();
        pane.setId("friendUserList");
        pane.setPrefWidth(314);
        // 自动计算；userListView.setPrefHeight(70 * items.size() + 10);
        pane.setPrefHeight(0);
        pane.setLayoutX(-10);
        pane.getStyleClass().add("elementFriendUserList");
        ObservableList<Node> children = pane.getChildren();

        userListView = new ListView<>();
        userListView.setId("userListView");
        userListView.setPrefWidth(314);
        // 自动计算；userListView.setPrefHeight(70 * items.size() + 10);
        userListView.setPrefHeight(0);
        userListView.setLayoutX(-10);
        userListView.getStyleClass().add("elementFriendUser_listView");
        children.add(userListView);
    }

    public Pane pane() {
        return pane;
    }

}
