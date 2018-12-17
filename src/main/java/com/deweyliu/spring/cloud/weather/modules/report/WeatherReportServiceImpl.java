package com.deweyliu.spring.cloud.weather.modules.report;

import com.deweyliu.spring.cloud.weather.modules.weather.Weather;
import com.deweyliu.spring.cloud.weather.modules.weather.WeatherDataService;
import com.deweyliu.spring.cloud.weather.modules.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Weather Report Service
 *
 * @author DeweyLiu
 * @version 1.0.0
 * @date 2018/12/16 14:23
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return resp.getData();
    }
}
