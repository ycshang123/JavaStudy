package top.ycshang.address;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import top.ycshang.address.model.Person;
import top.ycshang.address.view.PersonController;

import java.io.IOException;
import java.time.LocalDate;

public class MainApp extends Application {

    private final ObservableList<Person> personData = FXCollections.observableArrayList();


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


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("view/person.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 980, 600);
        stage.setTitle("AddressBook");
        stage.setScene(scene);
        PersonController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        stage.show();
    }


    public ObservableList<Person> getPersonData() {
        return personData;
    }


}