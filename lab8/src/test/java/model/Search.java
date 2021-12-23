package model;

import java.util.Date;

public class Search {
    private String arrivalFormText;
    private String departureFormText;

    public Search(String arrivalForm, String departureForm) {
        this.arrivalFormText = arrivalForm;
        this.departureFormText = departureForm;
    }


    public String getArrivalFormText() {
        return arrivalFormText;
    }

    public void setArrivalFormText(String arrivalFormText) {
        this.arrivalFormText = arrivalFormText;
    }

    public String getDepartureFormText() {
        return departureFormText;
    }

    public void setDepartureFormText(String departureFormText) {
        this.departureFormText = departureFormText;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Search)) return false;
        Search form = (Search) obj;
        return form.arrivalFormText.equals(this.getArrivalFormText())
                && form.departureFormText.equals(this.getDepartureFormText());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
