package top.ycshang.chatui.view.chat;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import top.ycshang.chatui.util.CacheUtil;
import top.ycshang.chatui.util.Ids;
import top.ycshang.chatui.view.chat.element.group_bar_chat.ElementTalk;

import java.util.Date;

/**
 * @program: chat-ui
 * @description:
 * @author: ycshang
 * @create: 2021-10-22 22:19
 **/
public class ChatController extends ChatInit implements IChatMethod {

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEventDefine() {
        ChatEventDefine chatEventDefine = new ChatEventDefine(this);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void addTalkBox(int talkIdx, Integer talkType, String talkId, String talkName, String talkHead, String talkSketch, Date talkDate, Boolean selected) {
        // 填充到对话框
        ListView<Pane> talkList = $("talkList", ListView.class);
        // 判断会话框是否有该对象
        ElementTalk elementTalk = CacheUtil.talkMap.get(talkId);
        if (null != elementTalk) {
            Node talkNode = talkList.lookup("#" + Ids.ElementTalkId.createTalkPaneId(talkId));
            if (null == talkNode) {
                talkList.getItems().add(talkIdx, elementTalk.pane());
            }
            if (selected) {
                // 设置选中
                talkList.getSelectionModel().select(elementTalk.pane());
            }
            return;
        }
        // 初始化对话框元素
        ElementTalk talkElement = new ElementTalk(talkId, talkType, talkName, talkHead, talkSketch, talkDate);
        CacheUtil.talkMap.put(talkId, talkElement);
        // 填充到对话框
        ObservableList<Pane> items = talkList.getItems();
        Pane talkElementPane = talkElement.pane();
        // 添加到第一个位置
        if (talkIdx >= 0) {
            items.add(talkIdx, talkElementPane);
        } else {
            // 顺序添加
            items.add(talkElementPane);
        }
        if (selected) {
            talkList.getSelectionModel().select(talkElementPane);
        }
        // 对话框元素点击事件
        talkElementPane.setOnMousePressed(event -> System.out.println("点击对话框：" + talkName));
        // 鼠标事件 [移入 / 移出]
        talkElementPane.setOnMouseEntered(event -> talkElement.delete().setVisible(true));
        talkElementPane.setOnMouseExited(event -> talkElement.delete().setVisible(false));
        // 从对话框中删除
        talkElement.delete().setOnMouseClicked(event -> {
            System.out.println("删除对话框：" + talkName);
            talkList.getItems().remove(talkElementPane);
            talkElement.clearMsgSketch();
        });
    }
}