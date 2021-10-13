package top.ycshang.address;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import top.ycshang.address.config.AppConfig;
import top.ycshang.address.model.Person;
import top.ycshang.address.view.BirthdayStatisticsController;
import top.ycshang.address.view.PersonController;
import top.ycshang.address.view.PersonEditController;
import top.ycshang.address.view.RootController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class MainApp extends Application {

    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    private Stage primaryStage;

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
        return this.primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.getIcons().add(new Image(Objects.requireNonNull(MainApp.class.getResourceAsStream(AppConfig.icon))));
        primaryStage.setTitle(AppConfig.title);
        initRootLayout();
        showPerson();
    }

    public void initRootLayout() {
        try {
            //加载根布局
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/root-layout.fxml"));
            rootLayout = fxmlLoader.load();
            RootController rootController = fxmlLoader.getController();
            rootController.setMainApp(this);
            //创建以根布局为内容的场景
            Scene scene = new Scene(rootLayout, AppConfig.stageWidth, AppConfig.stageHeight);
            scene.getStylesheets().add(Objects.requireNonNull(MainApp.class.getResource("css/style.css")).toExternalForm());
            //主窗体加入根布局
            primaryStage.setScene(scene);
            primaryStage.setResizable(AppConfig.stageResizable);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPerson() {
        try {
            //加载人员显示面板
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/person.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            //根布局中间部分加入人员显示面板
            rootLayout.setCenter(anchorPane);
            //获得PersonController控制器
            PersonController personController = fxmlLoader.getController();
            //向控制器传参
            personController.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEditPerson(Person person, String type) {
        try {
            //加载人员显示面板
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/person-edit.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            //根布局中间部分加入人员编辑面板
            rootLayout.setCenter(anchorPane);
            //获得PersonController控制器
            PersonEditController personController = fxmlLoader.getController();
            //向控制器传参
            personController.setArgs(person, type);
            personController.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }


    public void showBirthdayStatistics() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/birthday-statistics.fxml"));
            AnchorPane page = fxmlLoader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            BirthdayStatisticsController controller = fxmlLoader.getController();
            controller.setPersonData(personData);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}