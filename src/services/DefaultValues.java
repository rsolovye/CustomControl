package services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import protocol.FemaleGameteSource;

import java.util.HashMap;

/**
 * Created by bobsol on 29.03.17.
 */
public class DefaultValues {
    public static ObservableList<String> EMBRYOLOGIST = FXCollections.observableArrayList();
    public static ObservableList<FemaleGameteSource> FEMALE_SOURCE_NEW = FXCollections.observableArrayList();

    public static ObservableList<FemaleGameteSource> getObservableList(String list){
        //TODO
        if (FEMALE_SOURCE_NEW.size() == 0 )
        {

        }

        HashMap<String, String> m = new HashMap<>();
        m.put("gameteSources", "Пациентка");
        m.put("guid", "ЧУЧУ");
        m.put("gameteType", "Свежие");
        m.put("cryoDate", "");
        m.put("witness", "");
        m.put("follicleCount", "8");
        FEMALE_SOURCE_NEW.add(new FemaleGameteSource(m));

        return FEMALE_SOURCE_NEW;

    }
}
