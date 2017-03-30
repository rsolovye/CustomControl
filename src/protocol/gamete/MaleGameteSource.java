package protocol.gamete;

import java.util.HashMap;

/**
 * Created by bobsol on 29.03.17.
 */
public class MaleGameteSource {





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


    private final String guid;
    private final String gameteSource;
    private final String gameteType;
    private final String cryoDate;
    private final String witness;

    public String getBiopsyType() {
        return biopsyType;
    }

    private final String biopsyType;

    public MaleGameteSource(HashMap<String, String> map){
        guid = map.get("guid");
        gameteSource = map.get("gameteSource");
        gameteType = map.get("gameteType");
        cryoDate = map.get("cryoDate");
        witness = map.get("witness");
        biopsyType = map.get("biopsyType");
    }
    public MaleGameteSource(){
        guid = "";
        gameteSource = "";
        gameteType = "";
        cryoDate = "";
        witness = "";
        biopsyType = "";
    }

    public MaleGameteSource(String guid, String gameteSource, String gameteType, String cryoDate, String witness, String biopsyType){
        this.guid = guid;
        this.gameteSource = gameteSource;
        this.gameteType = gameteType;
        this.cryoDate = cryoDate;
        this.witness = witness;
        this.biopsyType = biopsyType;
    }

}
