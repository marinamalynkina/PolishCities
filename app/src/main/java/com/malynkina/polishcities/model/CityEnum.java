package com.malynkina.polishcities.model;

public enum CityEnum {

    gdansk("Gdańsk",54.3514014,18.6401031),
    warsaw("Warszawa",52.2376503,21.011645),
    poznan("Poznań", 52.407078,16.895044),
    bialostok("Białystok", 53.1372992,23.153256),
    wroclaw("Wrocław", 51.1113123,17.032348),
    katowice("Katowice", 50.254235,19.0095725),
    krakow("Kraków", 50.0625904,19.9374);


    public final String title;
    public final double lat;
    public final double lng;

    CityEnum(String title, double lat, double lng) {
        this.title = title;
        this.lat = lat;
        this.lng = lng;
    }

    public static CityEnum getValueByTitle(String title) {
        for (CityEnum city: CityEnum.values()) {
            if (city.title.equals(title))
                return city;
        }
        return null;
    }
}


//enum class CityEnum(
//	val title: String,
//	val lat: Double,
//	val lng: Double
//) {
//	gdansk("Gdańsk",54.3514014,18.6401031),
//	warsaw("Warszawa",52.2376503,21.011645),
//	poznan("Poznań", 52.407078,16.895044),
//	bialostok("Białystok", 53.1372992,23.153256),
//	wroclaw("Wrocław", 51.1113123,17.032348),
//	katowice("Katowice", 50.254235,19.0095725),
//	krakow("Kraków", 50.0625904,19.9374);
//
//	companion object {
//
//		fun getValueByTitle(title: String?): CityEnum? {
//			CityEnum.values().forEach {
//				if (it.title == title) return it
//			}
//			return null
//		}
//	}
//}
