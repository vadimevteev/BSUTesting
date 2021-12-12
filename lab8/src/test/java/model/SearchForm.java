package model;

public class SearchForm {
    private String arrivalFormText;
    private String departureFormText;

    public SearchForm(String arrivalForm, String departureForm) {
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
        if(!(obj instanceof SearchForm)) return false;
        SearchForm form = (SearchForm) obj;
        return form.arrivalFormText.equals(this.getArrivalFormText())
                && form.departureFormText.equals(this.getDepartureFormText());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
