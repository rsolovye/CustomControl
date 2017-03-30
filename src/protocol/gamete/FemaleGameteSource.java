package protocol.gamete;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.VBox;

import java.util.HashMap;

/**
 * Created by bobsol on 29.03.17.
 */
public class FemaleGameteSource {



    private String guid;
    private String gameteSource;

    public String getGuid() {
        return guid;
    }

    public String getGameteSource() {
        return gameteSource;
    }

    public String getGameteType() {
        return gameteType;
    }

    public String getCryoDate() {
        return cryoDate;
    }

    public String getWitness() {
        return witness;
    }

    public String getFollicleCount() {
        return follicleCount;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setGameteSource(String gameteSource) {
        this.gameteSource = gameteSource;
    }

    public void setGameteType(String gameteType) {
        this.gameteType = gameteType;
    }

    public void setCryoDate(String cryoDate) {
        this.cryoDate = cryoDate;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public void setFollicleCount(String follicleCount) {
        this.follicleCount = follicleCount;
    }

    private String gameteType;
    private  String cryoDate;
    private  String witness;
    private String follicleCount;

    public FemaleGameteSource(HashMap<String, String> map){
        guid = map.get("guid");
        gameteSource = map.get("gameteSource");
        gameteType = map.get("gameteType");
        cryoDate = map.get("cryoDate");
        witness = map.get("witness");
        follicleCount = map.get("follicleCount");
    }
    public FemaleGameteSource(){
        guid = "";
        gameteSource = "";
        gameteType = "";
        cryoDate = "";
        witness = "";
        follicleCount = "";
    }

    public FemaleGameteSource(String guid, String gameteSource, String gameteType, String cryoDate, String witness, String follicleCount){
        this.guid = guid;
        this.gameteSource = gameteSource;
        this.gameteType = gameteType;
        this.cryoDate = cryoDate;
        this.witness = witness;
        this.follicleCount = follicleCount;
    }

}
