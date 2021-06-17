package si.surya.holiday.service;

import retrofit2.Call;
import retrofit2.http.GET;
import si.surya.holiday.model.holiday.HolidayDiscoverResponse;

public interface HolidayRepository {
    @GET("/v1/holidays?pretty&key=ab414614-a455-424b-91a7-5e206b34755e&country=ID&year=2020")
    Call<HolidayDiscoverResponse> getHolidayDiscover();

}
