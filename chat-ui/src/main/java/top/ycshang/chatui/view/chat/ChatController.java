package top.ycshang.chatui.view.chat;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import top.ycshang.chatui.util.CacheUtil;
import top.ycshang.chatui.util.Ids;
import top.ycshang.chatui.view.chat.data.GroupsData;
import top.ycshang.chatui.view.chat.data.RemindCount;
import top.ycshang.chatui.view.chat.data.TalkData;
import top.ycshang.chatui.view.chat.group_bar_chat.ElementInfoBox;
import top.ycshang.chatui.view.chat.group_bar_chat.ElementTalk;
import top.ycshang.chatui.view.chat.group_bar_friend.ElementFriendGroup;
import top.ycshang.chatui.view.chat.group_bar_friend.ElementFriendNewUser;
import top.ycshang.chatui.view.chat.group_bar_friend.ElementFriendUser;

import java.util.Date;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 22:19
 **/
public class ChatController extends ChatInit implements IChatMethod {
    private ChatView chatView;
    private ChatEventDefine chatEventDefine;

    public ChatController(IChatEvent chatEvent) {
        super(chatEvent);
    }

    @Override
    public void initView() {
        chatView = new ChatView(this, chatEvent);
    }

    @Override
    public void initEventDefine() {
        chatEventDefine = new ChatEventDefine(this, chatEvent, this);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void setUserInfo(String userId, String userNickName, String userHead) {
        super.userId = userId;
        super.userNickName = userNickName;
        super.userHead = userHead;
        Button button = $("barPortrait", Button.class);
        button.setStyle(String.format("-fx-background-image: url('%s')", userHead));
    }


    @Override
    public void addTalkBox(int talkIdx, Integer talkType, String talkId, String talkName, String talkHead, String talkSketch, Date talkDate, Boolean selected) {
        // ??????????????????
        ListView talkList = $("talkList", ListView.class);
        // ?????????????????????????????????
        ElementTalk elementTalk = CacheUtil.talkMap.get(talkId);
        if (null != elementTalk) {
            Node talkNode = talkList.lookup("#" + Ids.ElementTalkId.createTalkPaneId(talkId));
            if (null == talkNode) {
                talkList.getItems().add(talkIdx, elementTalk.pane());
            }
            if (selected) {
                // ????????????
                talkList.getSelectionModel().select(elementTalk.pane());
            }
            return;
        }
        // ????????????????????????
        ElementTalk talkElement = new ElementTalk(talkId, talkType, talkName, talkHead, talkSketch, talkDate);
        CacheUtil.talkMap.put(talkId, talkElement);
        // ??????????????????
        ObservableList<Pane> items = talkList.getItems();
        Pane talkElementPane = talkElement.pane();
        // ????????????????????????
        if (talkIdx >= 0) {
            items.add(talkIdx, talkElementPane);
        } else {
            // ????????????
            items.add(talkElementPane);
        }
        if (selected) {
            talkList.getSelectionModel().select(talkElementPane);
        }
        // ???????????????????????????
        talkElementPane.setOnMousePressed(event -> {
            // ???????????????
            fillInfoBox(talkElement, talkName);
            // ??????????????????
            Label msgRemind = talkElement.msgRemind();
            msgRemind.setUserData(new RemindCount(0));
            msgRemind.setVisible(false);
        });

        // ???????????? [??????/??????]
        talkElementPane.setOnMouseEntered(event -> talkElement.delete().setVisible(true));
        talkElementPane.setOnMouseExited(event -> talkElement.delete().setVisible(false));
        // ?????????????????????
        talkElement.delete().setOnMouseClicked(event -> {
            chatEvent.doEventDelTalkUser(super.userId, talkId);
            //System.out.println("??????????????????" + talkName);
            talkList.getItems().remove(talkElementPane);
            talkElement.clearMsgSketch();
        });
    }

    /**
     * ????????????
     * ???????????????????????????
     *
     * @param talkElement ???????????????
     * @param talkName    ???????????????
     */
    private void fillInfoBox(ElementTalk talkElement, String talkName) {
        String talkId = talkElement.pane().getUserData().toString();
        // ??????????????????
        Pane infoPaneBox = $("info_pane_box", Pane.class);
        String boxUserId = (String) infoPaneBox.getUserData();
        // ????????????????????????[talkId]???????????????????????????
        if (talkId.equals(boxUserId)) {
            return;
        }
        ListView<Pane> listView = talkElement.infoBoxList();
        infoPaneBox.setUserData(talkId);
        infoPaneBox.getChildren().clear();
        infoPaneBox.getChildren().add(listView);
        // ???????????????
        Label infoName = $("info_name", Label.class);
        infoName.setText(talkName);
    }

    @Override
    public void addTalkMsgUserLeft(String talkId, String msg, Integer msgType, Date msgDate, Boolean idxFirst, Boolean selected, Boolean isRemind) {
        ElementTalk talkElement = CacheUtil.talkMap.get(talkId);
        ListView<Pane> listView = talkElement.infoBoxList();
        TalkData talkUserData = (TalkData) listView.getUserData();
        Pane left = new ElementInfoBox().left(talkUserData.getTalkName(), talkUserData.getTalkHead(), msg, msgType);
        // ????????????
        listView.getItems().add(left);
        // ?????????
        listView.scrollTo(left);
        talkElement.fillMsgSketch(0 == msgType ? msg : "[??????]", msgDate);
        // ????????????&??????
        chatView.updateTalkListIdxAndSelected(0, talkElement.pane(), talkElement.msgRemind(), idxFirst, selected, isRemind);
    }

    @Override
    public void addTalkMsgGroupLeft(String talkId, String userId, String userNickName, String userHead, String msg, Integer msgType, Date msgDate, Boolean idxFirst, Boolean selected, Boolean isRemind) {
        // ?????????????????????
        if (super.userId.equals(userId)) {
            return;
        }
        ElementTalk talkElement = CacheUtil.talkMap.get(talkId);
        if (null == talkElement) {
            GroupsData groupsData = (GroupsData) $(Ids.ElementTalkId.createFriendGroupId(talkId), Pane.class).getUserData();
            if (null == groupsData) {
                return;
            }
            addTalkBox(0, 1, talkId, groupsData.getGroupName(), groupsData.getGroupHead(), userNickName + "???" + msg, msgDate, false);
            talkElement = CacheUtil.talkMap.get(talkId);
            // ???????????? (???????????????????????????)
            System.out.println("???????????? ( ???????????????????????????)");
        }
        ListView<Pane> listView = talkElement.infoBoxList();
        TalkData talkData = (TalkData) listView.getUserData();
        Pane left = new ElementInfoBox().left(userNickName, userHead, msg, msgType);
        // ????????????
        listView.getItems().add(left);
        // ?????????
        listView.scrollTo(left);
        talkElement.fillMsgSketch(userNickName + "???" + msg, msgDate);
        // ???????????? & ??????
        chatView.updateTalkListIdxAndSelected(1, talkElement.pane(), talkElement.msgRemind(), idxFirst, selected, isRemind);
        // ???????????????????????????
        fillInfoBox(talkElement, talkData.getTalkName());
    }


    @Override
    public void addTalkMsgRight(String talkId, String msg, Integer msgType, Date msgData, Boolean idxFirst, Boolean selected, Boolean isRemind) {
        ElementTalk talkElement = CacheUtil.talkMap.get(talkId);
        ListView<Pane> listView = talkElement.infoBoxList();
        Pane right = new ElementInfoBox().right(userNickName, userHead, msg, msgType);
        // ????????????
        listView.getItems().add(right);
        // ?????????
        listView.scrollTo(right);
        talkElement.fillMsgSketch(0 == msgType ? msg : "[??????]", msgData);
        // ????????????&??????
        chatView.updateTalkListIdxAndSelected(0, talkElement.pane(), talkElement.msgRemind(), idxFirst, selected, isRemind);
    }

    @Override
    public double getToolFaceX() {
        return x() + width() - 960;
    }

    @Override
    public double getToolFaceY() {
        return y() + height() - 180;
    }

    @Override
    public void addFriendGroup(String groupId, String groupName, String groupHead) {
        ElementFriendGroup elementFriendGroup = new ElementFriendGroup(groupId, groupName, groupHead);
        Pane pane = elementFriendGroup.pane();
        // ?????????????????????
        ListView<Pane> groupListView = $("groupListView", ListView.class);
        ObservableList<Pane> items = groupListView.getItems();
        items.add(pane);
        groupListView.setPrefHeight(80 * items.size());
        $("friendGroupList", Pane.class).setPrefHeight(80 * items.size());

        // ??????????????????[?????????????????????]??????????????????????????????????????????????????????
        Pane detailContent = new Pane();
        detailContent.setPrefSize(850, 560);
        detailContent.getStyleClass().add("friendGroupDetailContent");
        ObservableList<Node> children = detailContent.getChildren();

        Button sendMsgButton = new Button();
        sendMsgButton.setId(groupId);
        sendMsgButton.getStyleClass().add("friendGroupSendMsgButton");
        sendMsgButton.setPrefSize(176, 50);
        sendMsgButton.setLayoutX(337);
        sendMsgButton.setLayoutY(450);
        sendMsgButton.setText("????????????");
        chatEventDefine.doEventOpenFriendGroupSendMsg(sendMsgButton, groupId, groupName, groupHead);
        children.add(sendMsgButton);

        // ??????????????????
        pane.setOnMousePressed(event -> {
            clearViewListSelectedAll($("friendList", ListView.class), $("userListView", ListView.class));
            chatView.setContentPaneBox(groupId, groupName, detailContent);
        });
        chatView.setContentPaneBox(groupId, groupName, detailContent);
    }

    @Override
    public void addFriendUser(boolean selected, String userFriendId, String userFriendNickName, String userFriendHead) {
        ElementFriendUser friendUser = new ElementFriendUser(userFriendId, userFriendNickName, userFriendHead);
        Pane pane = friendUser.pane();
        // ?????????????????????
        ListView<Pane> userListView = $("userListView", ListView.class);
        ObservableList<Pane> items = userListView.getItems();
        items.add(pane);
        userListView.setPrefHeight(80 * items.size());
        $("friendUserList", Pane.class).setPrefHeight(80 * items.size());
        // ??????
        if (selected) {
            userListView.getSelectionModel().select(pane);
        }

        // ??????????????????[?????????????????????]??????????????????????????????????????????????????????
        Pane detailContent = new Pane();
        detailContent.setPrefSize(850, 560);
        detailContent.getStyleClass().add("friendUserDetailContent");
        ObservableList<Node> children = detailContent.getChildren();

        Button sendMsgButton = new Button();
        sendMsgButton.setId(userFriendId);
        sendMsgButton.getStyleClass().add("friendUserSendMsgButton");
        sendMsgButton.setPrefSize(176, 50);
        sendMsgButton.setLayoutX(337);
        sendMsgButton.setLayoutY(450);
        sendMsgButton.setText("????????????");
        chatEventDefine.doEventOpenFriendUserSendMsg(sendMsgButton, userFriendId, userFriendNickName, userFriendHead);
        children.add(sendMsgButton);
        // ??????????????????
        pane.setOnMousePressed(event -> {
            clearViewListSelectedAll($("friendList", ListView.class), $("groupListView", ListView.class));
            chatView.setContentPaneBox(userFriendId, userFriendNickName, detailContent);
        });
        chatView.setContentPaneBox(userFriendId, userFriendNickName, detailContent);
    }

    @Override
    public void addNewFriend(String userId, String userNickName, String userHead, Integer status) {
        ElementFriendNewUser friendNewUser = new ElementFriendNewUser(userId, userNickName, userHead, status);
        Pane pane = friendNewUser.pane();
        // ?????????????????????
        ListView<Pane> friendNewListView = $("friendNewListView", ListView.class);
        ObservableList<Pane> items = friendNewListView.getItems();
        items.add(pane);
        // ????????????
        friendNewUser.statusLabel().setOnMousePressed(event -> {
            chatEvent.doEventAddNewUser(super.userId, userId);
        });
    }
}
