package service;

import model.Search;

public class SearchFormCreator {
    private static final String TEST_DATA_SEARCH_FORM_DEPARTURE = "testdata.searchForm.departure";
    private static final String TEST_DATA_SEARCH_FORM_ARRIVAL = "testdata.searchForm.arrival";
    private static final String TEST_DATA_SEARCH_FORM_DISTANT_ARRIVAL = "testdata.searchForm.distantArrival";

    public static Search createFormWithoutData(){
        return new Search("","");
    }

    public static Search createFormWithSamePoints(){
        return new Search(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE));
    }

    public static Search createFormWithData(){
        return new Search(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_ARRIVAL));
    }

    public static Search createFormWithDistantTown(){
        return new Search(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DISTANT_ARRIVAL));
    }

}
