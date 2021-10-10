package top.ycshang.address;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import top.ycshang.address.model.Person;
import top.ycshang.address.view.PersonController;
import top.ycshang.address.view.PersonEditController;

import java.io.IOException;
import java.time.LocalDate;

public class MainApp extends Application {

    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    private Stage stage;

    private BorderPane rootLayout;

    public MainApp() {
        personData.add(new Person("王林", "软件2026", "男", "江苏南京",
                LocalDate.of(2000, 10, 24), new Image("https://wx1.sinaimg.cn/mw690/00669kengy1gumd80a0o7j60fk0fkdii02.jpg")));
        personData.add(new Person("彭海洋", "软件2026", "男", "江苏扬州",
                LocalDate.of(1999, 10, 24), new Image("https://wx3.sinaimg.cn/mw690/00669kengy1gumd7xt4lpj60cv0cv77102.jpg")));
        personData.add(new Person("郭佳", "软件2026", "女", "江苏苏州",
                LocalDate.of(2001, 11, 24), new Image("https://wx1.sinaimg.cn/mw690/00669kengy1gux8nqvkzaj61130u0dtl02.jpg")));
        personData.add(new Person("黄志伟", "软件2026", "男", "江苏泰州",
                LocalDate.of(2000, 10, 24), new Image("https://wx3.sinaimg.cn/mw690/00669kengy1gumd7uvvlxj60o70o7gxi02.jpg")));
        personData.add(new Person("张珂", "软件2026", "女", "江苏徐州",
                LocalDate.of(2001, 9, 11), new Image("https://wx3.sinaimg.cn/mw690/00669kengy1gumd7vrcroj60dl0dlabw02.jpg")));
        personData.add(new Person("赵丹", "软件2036", "女", "江苏南通",
                LocalDate.of(2000, 10, 24), new Image("https://wx2.sinaimg.cn/mw690/00669kengy1gumd86b16ij60fh0fh76f02.jpg")));
        personData.add(new Person("张建凤", "软件2036", "女", "江苏无锡",
                LocalDate.of(2001, 2, 24), new Image("https://wx2.sinaimg.cn/mw690/00669kengy1gumd86b16ij60fh0fh76f02.jpg")));
        personData.add(new Person("杨阳", "软件1851", "男", "江苏南京",
                LocalDate.of(2000, 10, 23), new Image("https://wx4.sinaimg.cn/mw690/00669kengy1gumd7zbqknj60i20i1tde02.jpg")));
        personData.add(new Person("尚宇驰", "软件1851", "女", "江苏徐州",
                LocalDate.of(2000, 10, 24), new Image("https://wx4.sinaimg.cn/mw690/00669kengy1gumd7zbqknj60i20i1tde02.jpg")));
        personData.add(new Person("陈蓉琪", "软件1851", "女", "江苏南京",
                LocalDate.of(2000, 3, 21), new Image("https://wx3.sinaimg.cn/mw690/00669kengy1gumd7ry4d7j60en0emgoj02.jpg")));
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("AddressBook");
        initRootLayout();
        showPerson();
    }

    public void initRootLayout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/root-layout.fxml"));
            rootLayout = fxmlLoader.load();
            Scene scene = new Scene(rootLayout, 820, 540);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPerson() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/person.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            rootLayout.setCenter(anchorPane);
            PersonController personController = fxmlLoader.getController();
            personController.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showNewPersonStage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/person-edit.fxml"));
            AnchorPane anchorPane = loader.load();
            Stage editStage = new Stage();
            editStage.setTitle("Edit Person");
            Parent root;
            Scene scene = new Scene(anchorPane, 640, 480);
            editStage.setScene(scene);
            PersonEditController controller = loader.getController();
            controller.setEditStage(editStage);
            controller.setMainApp(this);
            editStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }


}