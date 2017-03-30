package protocol.gamete;


import cells.EditCell;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import session.ControlledScreen;

/**
 * Created by bobsol on 29.03.17.
 */
public class GameteSourcesController extends ControlledScreen {


TableView<FemaleGameteSource> femaleTable;
TableView<MaleGameteSource> maleTable;

    public GameteSourcesController() {

        TableColumn<FemaleGameteSource, String> gameteSourceColumn = new TableColumn<>("Источник женских гамет");
        gameteSourceColumn.setMinWidth(150);
        gameteSourceColumn.setCellValueFactory(new PropertyValueFactory<>("gameteSource"));


        TableColumn<FemaleGameteSource, String> gameteTypeColumn = new TableColumn<>("Тип");
        gameteTypeColumn.setCellValueFactory(new PropertyValueFactory<>("gameteType"));
        gameteTypeColumn.setMinWidth(100);

        TableColumn<FemaleGameteSource, String> cryoDateColumn = new TableColumn<>("Дата крио");
        cryoDateColumn.setMinWidth(100);
        cryoDateColumn.setCellValueFactory(new PropertyValueFactory<>("cryoDate"));

        TableColumn<FemaleGameteSource, String> witnessColumn = new TableColumn<>("Свидетель");
        witnessColumn.setCellValueFactory(new PropertyValueFactory<>("witness"));
        witnessColumn.setMinWidth(100);

        TableColumn<FemaleGameteSource, String> follicleCountColumn = new TableColumn<>("Кол-во фолликулов");
        follicleCountColumn.setMinWidth(70);
        follicleCountColumn.setCellValueFactory(new PropertyValueFactory<>("follicleCount"));







        femaleTable = new TableView<>();

        femaleTable.setItems(getFemaleGameteList());

        femaleTable.getColumns().addAll(gameteSourceColumn, gameteTypeColumn, cryoDateColumn, witnessColumn, follicleCountColumn);


        femaleTable.getSelectionModel().setCellSelectionEnabled(true);
        femaleTable.setEditable(true);

        femaleTable.setOnKeyPressed(event -> {
            TablePosition<FemaleGameteSource, ?> pos = femaleTable.getFocusModel().getFocusedCell() ;
            if (pos != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode().isArrowKey()
                    || event.getCode().getName().compareToIgnoreCase("TAB") == 0
                    || event.getCode().getName().compareToIgnoreCase("ENTER") == 0 ) ) {
                femaleTable.edit(pos.getRow(), pos.getTableColumn());
            }
        });
        femaleTable.setOnKeyReleased(event -> {
            TablePosition<FemaleGameteSource, ?> pos = femaleTable.getFocusModel().getFocusedCell() ;
            if (pos != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode().isArrowKey()
                    || event.getCode().getName().compareToIgnoreCase("TAB") == 0
                    || event.getCode().getName().compareToIgnoreCase("ENTER") == 0 ) ) {

                femaleTable.edit(pos.getRow(), pos.getTableColumn());
            }
        });


        Callback<TableColumn<FemaleGameteSource, String>, TableCell<FemaleGameteSource, String>> comboBoxCellFactory
                = (TableColumn<FemaleGameteSource, String> param) -> new ComboBoxEditingCell();

        Callback<TableColumn<FemaleGameteSource, String>, TableCell<FemaleGameteSource, String>> textFieldCellFactory
                = (TableColumn<FemaleGameteSource, String> param) -> new EditingCell();


        follicleCountColumn.setCellFactory(textFieldCellFactory);
        follicleCountColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<FemaleGameteSource, String> t) -> (t.getTableView().getItems()
                        .get(t.getTablePosition().getRow()))
                        .setFollicleCount(new SimpleStringProperty(t.getNewValue()).get()));


        witnessColumn.setCellFactory(comboBoxCellFactory);
        witnessColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<FemaleGameteSource, String> t) -> (t.getTableView().getItems()
                        .get(t.getTablePosition().getRow()))
                        .setWitness(new SimpleStringProperty(t.getNewValue()).get()));

        femaleTable.setFixedCellSize(25);
        femaleTable.prefHeightProperty().bind(Bindings.size(femaleTable.getItems()).multiply(femaleTable.getFixedCellSize()).add(30));

        TableColumn<MaleGameteSource, String> maleGameteSourceColumn = new TableColumn<>("Источник мужских гамет");
        maleGameteSourceColumn.setMinWidth(150);
        maleGameteSourceColumn.setCellValueFactory(new PropertyValueFactory<>("gameteSource"));

        TableColumn<MaleGameteSource, String> maleGameteTypeColumn = new TableColumn<>("Тип");
        maleGameteTypeColumn.setCellValueFactory(new PropertyValueFactory<>("gameteType"));
        maleGameteTypeColumn.setMinWidth(100);

        TableColumn<MaleGameteSource, String> maleCryoDateColumn = new TableColumn<>("Дата крио");
        maleCryoDateColumn .setMinWidth(100);
        maleCryoDateColumn .setCellValueFactory(new PropertyValueFactory<>("cryoDate"));

        TableColumn<MaleGameteSource, String> maleWitnessColumn = new TableColumn<>("Свидетель");
        maleWitnessColumn.setCellValueFactory(new PropertyValueFactory<>("witness"));
        maleWitnessColumn.setMinWidth(100);

        TableColumn<MaleGameteSource, String> biopsyTypeColumn = new TableColumn<>("Биоптат");
        biopsyTypeColumn.setMinWidth(70);
        biopsyTypeColumn.setCellValueFactory(new PropertyValueFactory<>("biopsyType"));

        maleTable = new TableView<>();
        maleTable.setItems(getMaleGameteList());
        maleTable.getColumns().addAll(maleGameteSourceColumn, maleGameteTypeColumn, maleCryoDateColumn, maleWitnessColumn, biopsyTypeColumn);
        maleTable.setFixedCellSize(25);
        maleTable.prefHeightProperty().bind(Bindings.size(maleTable.getItems()).multiply(maleTable.getFixedCellSize()).add(30));

        getChildren().addAll(femaleTable, maleTable);

      //  loadFXML("gamete_sources.fxml", this);

        //femaleGameteSourceTableView.setItems(FXCollections.emptyObservableList());

//        ObservableList<MaleGameteSource> fl = FXCollections.observableArrayList();
//        fl.add(new MaleGameteSource());
//
//        femaleGameteSourceTableView.setItems(fl);

    }

    public ObservableList<FemaleGameteSource> getFemaleGameteList(){
        ObservableList<FemaleGameteSource> femaleList = FXCollections.observableArrayList();
        femaleList.add(new FemaleGameteSource("guid1", "Пациентка", "Крио", "20.12.2014", "Соловьев Р.С.", "8"));
        femaleList.add(new FemaleGameteSource("guid2", "ДК-007", "Свежие", "", "", "46"));
        femaleList.add(new FemaleGameteSource());
        return femaleList;
    }
    public ObservableList<MaleGameteSource> getMaleGameteList(){
        ObservableList<MaleGameteSource> maleList = FXCollections.observableArrayList();
        maleList.add(new MaleGameteSource("guid1", "Пациент", "Свежие", "", "", ""));
        return maleList;
    }



    static class ComboBoxEditingCell extends TableCell<FemaleGameteSource, String> {

        private ComboBox<String> comboBox;


        private ComboBoxEditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createComboBox();
                setText(null);
                setGraphic(comboBox);
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(getString());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (comboBox != null) {
                        comboBox.setValue(getString());
                    }
                    setText(item);
                    setGraphic(comboBox);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createComboBox() {
            ObservableList<String> embCombo = FXCollections.observableArrayList();


   embCombo.addAll("Соловьев Р.С.", "Лямина И.В.", "Хандога А.О.");

            comboBox = new ComboBox<>(embCombo);
            comboBoxConverter(comboBox);
            comboBox.valueProperty().set(getString());
            comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            comboBox.setOnAction((e) -> {
                // System.out.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
                commitEdit(comboBox.getSelectionModel().getSelectedItem());
            });
//            comboBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//                if (!newValue) {
//                    commitEdit(comboBox.getSelectionModel().getSelectedItem());
//                }
//            });
        }

        private void comboBoxConverter(ComboBox<String> comboBox) {
            // Define rendering of the list of values in ComboBox drop down.
            comboBox.setCellFactory((c) -> {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item);
                        }
                    }
                };
            });
        }

        private String getString() {
            return getItem() == null ? new String("") : getItem();
        }
    }


    class EditingCell extends TableCell<FemaleGameteSource, String> {

        private TextField textField;

        private EditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(item);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
//                        setGraphic(null);
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.setOnAction((e) -> commitEdit(textField.getText()));
            textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
                    System.out.println("Commiting " + textField.getText());
                    commitEdit(textField.getText());
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem();
        }
    }

    class EditingCell_focus extends TableCell<FemaleGameteSource, String> {

        private TextField textField;

        public EditingCell_focus() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0,
                                    Boolean arg1, Boolean arg2) {
                    if (!arg2) {
                        commitEdit(textField.getText());
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }

}
