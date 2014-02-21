package femr.util.DataStructure;

/**
 * Created by Danny on 2/17/14.
 */

import java.util.*;
import org.apache.commons.collections.map.MultiKeyMap;

/**
 * This DataStructure is designed for the patient vitals allowing us to search for vitals by date and vital name at the same time
 * we can also get a list of dates
 */
public class VitalMultiMap {

    private final MultiKeyMap vitalMap = new MultiKeyMap();
    private final List<String> dateList = new LinkedList<>();

    /**
     * Puts a value into the map and associatres the name and date as the two keys to the value
     * @param vitalName The name of the vital
     * @param date The date the vital was taken
     * @param value The value of the vital
     */
    public void put(String vitalName, String date, Object value) {
        vitalMap.put(vitalName, date, value);
        // check if the dated is already in the dateList if so don't add it
        if(!dateList.contains(date)) {
            dateList.add(date);
        }
    }

    /**
     * Gets a list of Date Keys and sorts them in descending order
     * @return A List of dates as type string
     */
    public List<String> getDateList() {
        Collections.sort(dateList, Collections.reverseOrder());
        return dateList;
    }

    /**
     * Given the vital name and date taken return the vital value
     * if the keys do not exist it returns null
     * @param vitalName the name of the vital
     * @param date the date the vital was taken
     * @return the value of the vital as on type Object or null if not found
     */
    public String get(String vitalName, String date) {
        if(vitalMap.containsKey(vitalName,date)) {
            return vitalMap.get(vitalName,date).toString();
        }
        return null;
    }
}