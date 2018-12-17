package com.deweyliu.spring.cloud.weather.modules.report;

import com.deweyliu.spring.cloud.weather.modules.weather.Weather;

/**
 * Weather Report Service
 *
 * @author DeweyLiu
 * @version 1.0.0
 * @date 2018/12/16 14:20
 */
public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     *
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
