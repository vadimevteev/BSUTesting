package service;

import model.SearchForm;

public class SearchFormCreator {
    public static final String DEPARTURE_FORM_TEXT = "Minsk";

    public static SearchForm createFormWithSamePoints(){
        return new SearchForm(DEPARTURE_FORM_TEXT, DEPARTURE_FORM_TEXT);
    }

}
