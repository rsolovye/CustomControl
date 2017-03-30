package protocol;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.VBox;

import java.util.HashMap;

/**
 * Created by bobsol on 29.03.17.
 */
public class FemaleGameteSource {

    public String getGuid() {
        return guid.get();
    }

    public SimpleStringProperty guidProperty() {
        return guid;
    }

    public SimpleStringProperty getGameteSource() {
        return gameteSource;
    }

    public SimpleStringProperty gameteSourceProperty() {
        return gameteSource;
    }

    public String getGameteType() {
        return gameteType.get();
    }

    public SimpleStringProperty gameteTypeProperty() {
        return gameteType;
    }

    public String getCryoDate() {
        return cryoDate.get();
    }

    public SimpleStringProperty cryoDateProperty() {
        return cryoDate;
    }

    public String getWitness() {
        return witness.get();
    }

    public SimpleStringProperty witnessProperty() {
        return witness;
    }

    public String getFollicleCount() {
        return follicleCount.get();
    }

    public SimpleStringProperty follicleCountProperty() {
        return follicleCount;
    }

    private final SimpleStringProperty guid;
    private final SimpleStringProperty gameteSource;
    private final SimpleStringProperty gameteType;
    private final SimpleStringProperty cryoDate;
    private final SimpleStringProperty witness;
    private final SimpleStringProperty follicleCount;

    public FemaleGameteSource(HashMap<String, String> map){
        guid = new SimpleStringProperty(map.get("guid"));
        gameteSource = new SimpleStringProperty(map.get("gameteSource"));
        gameteType = new SimpleStringProperty(map.get("gameteType"));
        cryoDate = new SimpleStringProperty(map.get("cryoDate"));
        witness = new SimpleStringProperty(map.get("witness"));
        follicleCount = new SimpleStringProperty(map.get("follicleCount"));
    }
    public FemaleGameteSource(){
        guid = new SimpleStringProperty("");
        gameteSource = new SimpleStringProperty("");
        gameteType = new SimpleStringProperty("");
        cryoDate = new SimpleStringProperty("");
        witness = new SimpleStringProperty("");
        follicleCount = new SimpleStringProperty("");
    }


    public void setGameteSource(SimpleStringProperty simpleStringProperty) {
        gameteSource.set(simpleStringProperty.get());
    }
}
