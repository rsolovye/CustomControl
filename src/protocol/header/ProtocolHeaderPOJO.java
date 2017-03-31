package protocol.header;

import cust.ProtocolHeader;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

/**
 * Created by bob on 3/31/17.
 */
public class ProtocolHeaderPOJO {


    private SimpleStringProperty guid;


    private SimpleStringProperty punctureDate, punctureTime, vrt_number, ivf_attempt, header_notes, femaleName, maleName, femaleDOB, maleDOB, femaleCode, maleCode, isOMS, punctureDoctor, diagnosis_1, diagnosis_2;

    public ProtocolHeaderPOJO(String guid){
        this.guid = new SimpleStringProperty(guid);

    }

    public String getGuid() {
        return guid.get();
    }

    public SimpleStringProperty guidProperty() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid.set(guid);
    }

    public String getPunctureDate() {
        return punctureDate.get();
    }

    public SimpleStringProperty punctureDateProperty() {
        return punctureDate;
    }

    public void setPunctureDate(String punctureDate) {
        this.punctureDate.set(punctureDate);
    }

    public String getPunctureTime() {
        return punctureTime.get();
    }

    public SimpleStringProperty punctureTimeProperty() {
        return punctureTime;
    }

    public void setPunctureTime(String punctureTime) {
        this.punctureTime.set(punctureTime);
    }

    public String getVrt_number() {
        return vrt_number.get();
    }

    public SimpleStringProperty vrt_numberProperty() {
        return vrt_number;
    }

    public void setVrt_number(String vrt_number) {
        this.vrt_number.set(vrt_number);
    }

    public String getIvf_attempt() {
        return ivf_attempt.get();
    }

    public SimpleStringProperty ivf_attemptProperty() {
        return ivf_attempt;
    }

    public void setIvf_attempt(String ivf_attempt) {
        this.ivf_attempt.set(ivf_attempt);
    }

    public String getHeader_notes() {
        return header_notes.get();
    }

    public SimpleStringProperty header_notesProperty() {
        return header_notes;
    }

    public void setHeader_notes(String header_notes) {
        this.header_notes.set(header_notes);
    }

    public String getFemaleName() {
        return femaleName.get();
    }

    public SimpleStringProperty femaleNameProperty() {
        return femaleName;
    }

    public void setFemaleName(String femaleName) {
        this.femaleName.set(femaleName);
    }

    public String getMaleName() {
        return maleName.get();
    }

    public SimpleStringProperty maleNameProperty() {
        return maleName;
    }

    public void setMaleName(String maleName) {
        this.maleName.set(maleName);
    }

    public String getFemaleDOB() {
        return femaleDOB.get();
    }

    public SimpleStringProperty femaleDOBProperty() {
        return femaleDOB;
    }

    public void setFemaleDOB(String femaleDOB) {
        this.femaleDOB.set(femaleDOB);
    }

    public String getMaleDOB() {
        return maleDOB.get();
    }

    public SimpleStringProperty maleDOBProperty() {
        return maleDOB;
    }

    public void setMaleDOB(String maleDOB) {
        this.maleDOB.set(maleDOB);
    }

    public String getFemaleCode() {
        return femaleCode.get();
    }

    public SimpleStringProperty femaleCodeProperty() {
        return femaleCode;
    }

    public void setFemaleCode(String femaleCode) {
        this.femaleCode.set(femaleCode);
    }

    public String getMaleCode() {
        return maleCode.get();
    }

    public SimpleStringProperty maleCodeProperty() {
        return maleCode;
    }

    public void setMaleCode(String maleCode) {
        this.maleCode.set(maleCode);
    }

    public String getIsOMS() {
        return isOMS.get();
    }

    public SimpleStringProperty isOMSProperty() {
        return isOMS;
    }

    public void setIsOMS(String isOMS) {
        this.isOMS.set(isOMS);
    }

    public String getPunctureDoctor() {
        return punctureDoctor.get();
    }

    public SimpleStringProperty punctureDoctorProperty() {
        return punctureDoctor;
    }

    public void setPunctureDoctor(String punctureDoctor) {
        this.punctureDoctor.set(punctureDoctor);
    }

    public String getDiagnosis_1() {
        return diagnosis_1.get();
    }

    public SimpleStringProperty diagnosis_1Property() {
        return diagnosis_1;
    }

    public void setDiagnosis_1(String diagnosis_1) {
        this.diagnosis_1.set(diagnosis_1);
    }

    public String getDiagnosis_2() {
        return diagnosis_2.get();
    }

    public SimpleStringProperty diagnosis_2Property() {
        return diagnosis_2;
    }

    public void setDiagnosis_2(String diagnosis_2) {
        this.diagnosis_2.set(diagnosis_2);
    }






}
