package com.compose.weatherapplite.utils

object WeatherAppConstants {

    // Integer Constants
    const val WEATHER_FORECAST_MAX = 10L

    const val WEATHER_CODE_CLEAR_SKY_1 = 0
    const val WEATHER_CODE_OVERCAST_1 = 1
    const val WEATHER_CODE_OVERCAST_2 = 2
    const val WEATHER_CODE_OVERCAST_3 = 3
    const val WEATHER_CODE_FOGGY_1 = 45
    const val WEATHER_CODE_FOGGY_2 = 48
    const val WEATHER_CODE_DRIZZLE_1 = 51
    const val WEATHER_CODE_DRIZZLE_2 = 53
    const val WEATHER_CODE_DRIZZLE_3 = 55
    const val WEATHER_CODE_DRIZZLE_4 = 56
    const val WEATHER_CODE_DRIZZLE_5 = 57
    const val WEATHER_CODE_RAIN_1 = 61
    const val WEATHER_CODE_RAIN_2 = 63
    const val WEATHER_CODE_RAIN_3 = 65
    const val WEATHER_CODE_HEAVYRAIN_1 = 66
    const val WEATHER_CODE_HEAVYRAIN_2 = 67
    const val WEATHER_CODE_SNOWFALL_1 = 71
    const val WEATHER_CODE_SNOWFALL_2 = 73
    const val WEATHER_CODE_SNOWFALL_3 = 75
    const val WEATHER_CODE_THUNDERSTORM_1 = 95
    const val WEATHER_CODE_THUNDERSTORM_2 = 96
    const val WEATHER_CODE_THUNDERSTORM_3 = 99

    val WEATHER_CODE_CLEAR_SKY_LIST = listOf(
        WEATHER_CODE_CLEAR_SKY_1
    )
    val WEATHER_CODE_OVERCAST_LIST = listOf(
        WEATHER_CODE_OVERCAST_1,
        WEATHER_CODE_OVERCAST_2,
        WEATHER_CODE_OVERCAST_3
    )
    val WEATHER_CODE_FOGGY_LIST = listOf(
        WEATHER_CODE_FOGGY_1,
        WEATHER_CODE_FOGGY_2
    )
    val WEATHER_CODE_DRIZZLE_LIST = listOf(
        WEATHER_CODE_DRIZZLE_1,
        WEATHER_CODE_DRIZZLE_2,
        WEATHER_CODE_DRIZZLE_3,
        WEATHER_CODE_DRIZZLE_4,
        WEATHER_CODE_DRIZZLE_5
    )
    val WEATHER_CODE_RAIN_LIST = listOf(
        WEATHER_CODE_RAIN_1,
        WEATHER_CODE_RAIN_2,
        WEATHER_CODE_RAIN_3
    )
    val WEATHER_CODE_HEAVYRAIN_LIST = listOf(
        WEATHER_CODE_HEAVYRAIN_1,
        WEATHER_CODE_HEAVYRAIN_2
    )
    val WEATHER_CODE_SNOWFALL_LIST = listOf(
        WEATHER_CODE_SNOWFALL_1,
        WEATHER_CODE_SNOWFALL_2,
        WEATHER_CODE_SNOWFALL_3
    )
    val WEATHER_CODE_THUNDERSTORM_LIST = listOf(
        WEATHER_CODE_THUNDERSTORM_1,
        WEATHER_CODE_THUNDERSTORM_2,
        WEATHER_CODE_THUNDERSTORM_3
    )

    const val WEATHER_RAIN_LEVEL_NONE = 0
    const val WEATHER_RAIN_LEVEL_VERY_LOW = 10
    const val WEATHER_RAIN_LEVEL_LOW = 30
    const val WEATHER_RAIN_LEVEL_MODERATE = 60
    const val WEATHER_RAIN_LEVEL_HIGH = 80
    const val WEATHER_RAIN_LEVEL_VERY_HIGH = 100

    const val TIME_12_HOUR_FORMAT = 12
    const val CITY_NAME_DELIMITER = ","
    const val CITY_NAME_LIST_SIZE_MAX = 3
    const val CITY_NAME_LIST_SIZE_MIN = 1

    // String Constants
    const val DAY_OF_WEEK_TODAY = "Today"
    const val PATTERN_FOR_LOCAL_DATE_TIME = "yyyy-MM-dd'T'HH:mm"

    const val WEATHER_MENU_SELECTOR_1 = "Today"
    const val WEATHER_MENU_SELECTOR_2 = "Tomorrow"
    const val WEATHER_MENU_SELECTOR_3 = "Next 10 days"

    const val WEATHER_UNKNOWN_LOCATION = "Unknown Locality"

    const val KEY_ANTE_MERIDIEM = "am"
    const val KEY_POST_MERIDIEM = "pm"

    const val MAP_STYLE_LIGHT = "[\n" +
        "    {\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"hue\": \"#baf4c4\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"saturation\": 10\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"water\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#effefd\"\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"all\",\n" +
        "        \"elementType\": \"labels\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"visibility\": \"off\"\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"administrative\",\n" +
        "        \"elementType\": \"labels\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"visibility\": \"on\"\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"road\",\n" +
        "        \"elementType\": \"all\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"visibility\": \"on\"\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"transit\",\n" +
        "        \"elementType\": \"all\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"visibility\": \"off\"\n" +
        "            }\n" +
        "        ]\n" +
        "    }\n" +
        "]\n"

    const val MAP_STYLE_DARK = "[\n" +
        "    {\n" +
        "        \"featureType\": \"all\",\n" +
        "        \"elementType\": \"labels.text.fill\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"saturation\": 36\n" +
        "            },\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 40\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"all\",\n" +
        "        \"elementType\": \"labels.text.stroke\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"visibility\": \"on\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 16\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"all\",\n" +
        "        \"elementType\": \"labels.icon\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"visibility\": \"off\"\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"administrative\",\n" +
        "        \"elementType\": \"geometry.fill\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 20\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"administrative\",\n" +
        "        \"elementType\": \"geometry.stroke\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 17\n" +
        "            },\n" +
        "            {\n" +
        "                \"weight\": 1.2\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"landscape\",\n" +
        "        \"elementType\": \"geometry\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 20\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"poi\",\n" +
        "        \"elementType\": \"geometry\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 21\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"road.highway\",\n" +
        "        \"elementType\": \"geometry.fill\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 17\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"road.highway\",\n" +
        "        \"elementType\": \"geometry.stroke\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 29\n" +
        "            },\n" +
        "            {\n" +
        "                \"weight\": 0.2\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"road.arterial\",\n" +
        "        \"elementType\": \"geometry\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 18\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"road.local\",\n" +
        "        \"elementType\": \"geometry\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 16\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"transit\",\n" +
        "        \"elementType\": \"geometry\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 19\n" +
        "            }\n" +
        "        ]\n" +
        "    },\n" +
        "    {\n" +
        "        \"featureType\": \"water\",\n" +
        "        \"elementType\": \"geometry\",\n" +
        "        \"stylers\": [\n" +
        "            {\n" +
        "                \"color\": \"#000000\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"lightness\": 17\n" +
        "            }\n" +
        "        ]\n" +
        "    }\n" +
        "]\n"
}
