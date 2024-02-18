package com.example.weatherapplication.Retrofit;

import com.example.weatherapplication.Model.ForecastResult;
import com.example.weatherapplication.Model.WeatherResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOpenWeatherMap {
    @GET("weather")
    Observable<WeatherResult> getWeatherByCityName(@Query("lat") String lat,
                                                   @Query("lon") String lng,
                                                   @Query("appid") String appid,
                                                   @Query("units") String units);

    @GET("weather")
    Observable<WeatherResult> getCityWeatherByCityName(@Query("q") String cityName,
                                                       @Query("appid") String appid,
                                                       @Query("units") String units);

    @GET("forecast")
    Observable<ForecastResult> getForecastByCityName(@Query("lat") String lat,
                                                     @Query("lon") String lng,
                                                     @Query("appid") String appid,
                                                     @Query("units") String units);
}
