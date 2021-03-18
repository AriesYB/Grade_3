package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Main app;

    public void setApp(Main app) {
        this.app = app;
    }

    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, String> tableColumn1;

    @FXML
    private TableColumn<User, String> tableColumn2;

    @FXML
    void initialize() {
        List<User> list = new ArrayList<>();
        list.add(new User("张三",20));
        list.add(new User("李四",21));
        list.add(new User("王五",22));
        list.add(new User("老六",23));

        ObservableList<User> observableList;
        observableList = FXCollections.observableList(list);

        //table添加数据
        tableview.setItems(observableList);

        //table列设置数据
        tableColumn1.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        tableColumn2.setCellValueFactory(cellData->cellData.getValue().ageProperty());

    }
}
