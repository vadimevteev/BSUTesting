package service;

import model.SearchForm;

public class SearchFormCreator {
    public static final String TEST_DATA_SEARCH_FORM_DEPARTURE = "testdata.searchForm.departure";

    public static SearchForm createFormWithSamePoints(){
        return new SearchForm(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE));
    }

}
