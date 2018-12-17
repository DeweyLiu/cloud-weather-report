package com.deweyliu.spring.cloud.weather.modules.job;

import com.deweyliu.spring.cloud.weather.modules.city.City;
import com.deweyliu.spring.cloud.weather.modules.city.CityDataService;
import com.deweyliu.spring.cloud.weather.modules.city.CityList;
import com.deweyliu.spring.cloud.weather.modules.weather.WeatherDataService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;


/**
 * Weather Data Sync Job
 *
 * @author DeweyLiu
 * @version 1.0.0
 * @date 2018/12/13 10:09
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job Start");
        //获取城市Id列表
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("Exception!", e);
        }
        //遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job");
            weatherDataService.syncDateByCityId(cityId);
        }
        logger.info("Weather Data Sync Job End");

    }
}
