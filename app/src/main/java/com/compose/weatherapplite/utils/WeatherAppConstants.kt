package com.compose.weatherapplite.utils

object WeatherAppConstants {
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