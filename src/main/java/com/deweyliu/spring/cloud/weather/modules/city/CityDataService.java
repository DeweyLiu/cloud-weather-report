package com.deweyliu.spring.cloud.weather.modules.city;

import java.util.List;

/**
 * City Data Service
 *
 * @author DeweyLiu
 * @version 1.0.0
 * @date 2018/12/13 11:20
 */
public interface CityDataService {
    List<City> listCity() throws Exception;
}
