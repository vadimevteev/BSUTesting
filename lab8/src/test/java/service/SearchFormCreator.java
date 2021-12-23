package service;

import model.SearchForm;

public class SearchFormCreator {
    private static final String TEST_DATA_SEARCH_FORM_DEPARTURE = "testdata.searchForm.departure";
    private static final String TEST_DATA_SEARCH_FORM_ARRIVAL = "testdata.searchForm.arrival";
    private static final String TEST_DATA_SEARCH_FORM_DISTANT_ARRIVAL = "testdata.searchForm.distantArrival";

    public static SearchForm createFormWithoutData(){
        return new SearchForm("","");
    }

    public static SearchForm createFormWithSamePoints(){
        return new SearchForm(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE));
    }

    public static SearchForm createFormWithData(){
        return new SearchForm(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_ARRIVAL));
    }

    public static SearchForm createFormWithDistantTown(){
        return new SearchForm(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DISTANT_ARRIVAL));
    }

}
