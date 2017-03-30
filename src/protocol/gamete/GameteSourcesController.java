package protocol.gamete;


import session.ControlledScreen;

/**
 * Created by bobsol on 29.03.17.
 */
public class GameteSourcesController extends ControlledScreen {



    public GameteSourcesController() {
        loadFXML("gamete_sources.fxml", this);

        //femaleGameteSourceTableView.setItems(FXCollections.emptyObservableList());

//        ObservableList<FemaleGameteSource> fl = FXCollections.observableArrayList();
//        fl.add(new FemaleGameteSource());
//
//        femaleGameteSourceTableView.setItems(fl);

    }





}
