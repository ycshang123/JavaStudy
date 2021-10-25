package top.ycshang.chatui.view.face;

/**
 * @program: chat-ui
 * @description: 定义表情框隐藏事件
 * @author: ycshang
 * @create: 2021-10-25 18:42
 **/
public class FaceEventDefine {
    private  FaceInit faceInit;

    public FaceEventDefine(FaceInit faceInit) {
        this.faceInit = faceInit;
        hideFace();
    }

    private void hideFace() {
        faceInit.root().setOnMouseExited(event -> faceInit.hide());
    }

}