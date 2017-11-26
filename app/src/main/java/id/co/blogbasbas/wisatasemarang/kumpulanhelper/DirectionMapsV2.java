package id.co.blogbasbas.wisatasemarang.kumpulanhelper;

import android.content.Context;
import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* ----------------------------------------------------------------------
* Silahkan untuk mengcopy, mendistribusikan dan menggunakan
* class ini sebebas-bebasnya, Tapi jangan menghapus bagian header ini.
*
* created by xrb21 riyadi.rb@gmail.com http://ercode.xyz
* ----------------------------------------------------------------------
*/

public class DirectionMapsV2 {
	private static final String TAG_START_LOCATION = "start_location";
	private static final String TAG_LAT = "lat";
	private static final String TAG_LNG = "lng";
	private static final String TAG_POLYLINE = "polyline";
	private static final String TAG_POINTS = "points";
	private static final String TAG_END_LOCATION = "end_location";
	private static final String TAG_DURATION = "duration";
	private static final String TAG_VALUE = "value";
	private static final String TAG_TEXT = "text";
	private static final String TAG_DISTANCE = "distance";
	private static final String TAG_LEGS = "legs";

	private static final String TAG_START_ADDRESS = "start_address";
	private static final String TAG_END_ADDRESS = "end_address";
	private static final String TAG_STEPS = "steps";
	private List<LatLng> polyz;
	private Context context;
	private String TAG_HTML_INSTRUCTION = "html_instructions";
	private int totalTime;

	public DirectionMapsV2(Context context) {
		this.context = context;
	}

	// menggambar polyline
	public void gambarRoute(GoogleMap map, String dataPoly) {

		polyz = decodePoly(dataPoly);
		for (int i = 0; i < polyz.size() - 1; i++) {
			LatLng src = polyz.get(i);
			LatLng dest = polyz.get(i + 1);
			Polyline line = map.addPolyline(new PolylineOptions()
					.add(new LatLng(src.latitude, src.longitude),
							new LatLng(dest.latitude, dest.longitude)).width(5)
					.color(Color.BLUE).geodesic(true));

		}
	}
	
	public void removePolyline(Polyline poli, GoogleMap map) {
		poli.remove();
	}
	
	public void gambarRoute(GoogleMap map, String dataPoly, int color) {

		polyz = decodePoly(dataPoly);
		for (int i = 0; i < polyz.size() - 1; i++) {
			LatLng src = polyz.get(i);
			LatLng dest = polyz.get(i + 1);
			Polyline poli = new Polyline(null);
			poli.remove();
			Polyline line = map.addPolyline(new PolylineOptions()
					.add(new LatLng(src.latitude, src.longitude),
							new LatLng(dest.latitude, dest.longitude)).width(5)
					.color(color).geodesic(true));

		}
	}

	/* Method to decode polyline points */
	static List<LatLng> decodePoly(String encoded) {

		List<LatLng> poly = new ArrayList<LatLng>();
		int index = 0, len = encoded.length();
		int lat = 0, lng = 0;

		while (index < len) {
			int b, shift = 0, result = 0;
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lat += dlat;

			shift = 0;
			result = 0;
			do {
				b = encoded.charAt(index++) - 63;
				result |= (b & 0x1f) << shift;
				shift += 5;
			} while (b >= 0x20);
			int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
			lng += dlng;

			LatLng p = new LatLng((((double) lat / 1E5)),
					(((double) lng / 1E5)));
			poly.add(p);
		}

		return poly;
	}

	// untuk memperoleh data durasi yang berbentuk tex
	public String getDurationText(JSONObject jsonObject) {
		try {
			JSONObject x = getLegs(jsonObject);
			JSONObject duration = x.getJSONObject(TAG_DURATION);
			String durasi = duration.getString(TAG_TEXT);
			return durasi;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// untuk memperoleh data durasi yang berbentuk data angka
	public int getDurationValue(JSONObject jsonObject) {
		try {
			JSONObject x = getLegs(jsonObject);
			JSONObject duration = x.getJSONObject(TAG_DURATION);
			int durasi = duration.getInt(TAG_VALUE);
			return durasi;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	// untuk memperoleh data jarak yang berbentuk tex
	public String getDistanceText(JSONObject jsonObject) {
		try {
			JSONObject x = getLegs(jsonObject);
			JSONObject duration = x.getJSONObject(TAG_DISTANCE);
			String durasi = duration.getString(TAG_TEXT);
			return durasi;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// untuk memperoleh data jarak yang berbentuk data angka
	public Integer getDistanceValue(JSONObject jsonObject) {
		try {
			JSONObject x = getLegs(jsonObject);
			JSONObject duration = x.getJSONObject(TAG_DISTANCE);
			Integer durasi = duration.getInt(TAG_VALUE);
			return durasi;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// untuk memdapatkan titik legs pada routes
	private JSONObject getLegs(JSONObject jsonObject) {
		JSONArray legs;
		try {
			legs = jsonObject.getJSONArray(TAG_LEGS);
			JSONObject x = legs.getJSONObject(0);

			return x;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// ambill start address
	public String getStarAddress(JSONObject jsonObject) {
		try {
			JSONObject x = getLegs(jsonObject);
			String text = x.getString(TAG_START_ADDRESS);
			return text;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// ambill end address
	public String getEndAddress(JSONObject jsonObject) {
		try {
			JSONObject x = getLegs(jsonObject);
			String text = x.getString(TAG_END_ADDRESS);
			return text;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public ArrayList<LatLng> getDirection(JSONObject jsonObject) {
		JSONObject startLocation, endLocation, intruksi, distance, duration, polyline;
		double lat, lng;
		ArrayList<LatLng> listLatLng = new ArrayList<LatLng>();
		JSONObject x = getLegs(jsonObject);
		JSONArray step;
		try {
			step = x.getJSONArray(TAG_STEPS);

			if (step.length() > 0) {
				for (int i = 0; i < step.length(); i++) {
					JSONObject stepx = step.getJSONObject(i);

					// ambil nilai untuk start point
					startLocation = stepx.getJSONObject(TAG_START_LOCATION);
					lat = Double.parseDouble(startLocation.getString(TAG_LAT));
					lng = Double.parseDouble(startLocation.getString(TAG_LNG));
					listLatLng.add(new LatLng(lat, lng));

					// ambil nilai polyline
					polyline = stepx.getJSONObject(TAG_POLYLINE);
					String point = polyline.getString(TAG_POINTS);
					List<LatLng> arr = decodePoly(point);
					for (int j = 0; j < arr.size(); j++) {
						listLatLng.add(new LatLng(arr.get(j).latitude, arr
								.get(j).longitude));
					}

					// ambil nilai untuk end point
					startLocation = stepx.getJSONObject(TAG_END_LOCATION);
					lat = Double.parseDouble(startLocation.getString(TAG_LAT));
					lng = Double.parseDouble(startLocation.getString(TAG_LNG));
					listLatLng.add(new LatLng(lat, lng));
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listLatLng;
	}
	
	public ArrayList<HashMap> getDirectionx(JSONObject jsonObject) {
		JSONObject startLocation, endLocation, intruksi, distance, duration, polyline;
		double lat, lng;
		ArrayList<HashMap> datax = new ArrayList<HashMap>();
		JSONObject x = getLegs(jsonObject);
		JSONArray step;
		try {
			step = x.getJSONArray(TAG_STEPS);

			if (step.length() > 0) {
				for (int i = 0; i < step.length(); i++) {
					JSONObject stepx = step.getJSONObject(i);
					HashMap data = new HashMap();
					
					// ambil nilai untuk start point
					startLocation = stepx.getJSONObject(TAG_START_LOCATION);
					lat = Double.parseDouble(startLocation.getString(TAG_LAT));
					lng = Double.parseDouble(startLocation.getString(TAG_LNG));
					data.put("start", new LatLng(lat, lng));
					
					//ambil nilai point
					endLocation = stepx.getJSONObject(TAG_END_LOCATION);
					lat = Double.parseDouble(endLocation.getString(TAG_LAT));
					lng = Double.parseDouble(endLocation.getString(TAG_LNG));
					data.put("end", new LatLng(lat, lng));
					
					//ambil html instruction
					String intruksix = stepx.getString(TAG_HTML_INSTRUCTION);
					data.put("intruksi", intruksix);
					
					//ambil distance text
					distance = stepx.getJSONObject(TAG_DISTANCE);
					String jarak = distance.getString(TAG_TEXT);;
					data.put("jarak", jarak);
					
					
					//ambil durasi text
					distance = stepx.getJSONObject(TAG_DURATION);
					String waktu = distance.getString(TAG_TEXT);;
					data.put("durasi", waktu);

					// ambil nilai polyline
					polyline = stepx.getJSONObject(TAG_POLYLINE);
					String point = polyline.getString(TAG_POINTS);
					data.put("points", point);
					
					datax.add(data);
					
					

				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datax;
	}
	
	public ArrayList<HashMap> getLegsx(JSONObject jsonObject) {
		JSONObject startLocation, endLocation, intruksi, distance, duration, polyline;
		double lat, lng;
		ArrayList<HashMap> datax = new ArrayList<HashMap>();
		JSONArray step;
		try {
			step = jsonObject.getJSONArray(TAG_LEGS);
			if (step.length() > 0) {
				int durasiTotal = 0;
				for (int i = 0; i < step.length(); i++) {
					JSONObject stepx = step.getJSONObject(i);
					HashMap data = new HashMap();
					
					// ambil nilai untuk start point
					startLocation = stepx.getJSONObject(TAG_START_LOCATION);
					lat = Double.parseDouble(startLocation.getString(TAG_LAT));
					lng = Double.parseDouble(startLocation.getString(TAG_LNG));
					data.put("start", new LatLng(lat, lng));
					
					//ambil nilai point
					endLocation = stepx.getJSONObject(TAG_END_LOCATION);
					lat = Double.parseDouble(endLocation.getString(TAG_LAT));
					lng = Double.parseDouble(endLocation.getString(TAG_LNG));
					data.put("end", new LatLng(lat, lng));
					
					//ambil html instruction
					String intruksix = stepx.getString(TAG_START_ADDRESS);
					data.put("startAddress", intruksix);
					intruksix = stepx.getString(TAG_END_ADDRESS);
					data.put("endAddress", intruksix);
					
					//ambil distance text
					distance = stepx.getJSONObject(TAG_DISTANCE);
					String jarak = distance.getString(TAG_TEXT);;
					data.put("jarak", jarak);
					
					
					//ambil durasi text
					distance = stepx.getJSONObject(TAG_DURATION);
					String waktu = distance.getString(TAG_TEXT);;
					data.put("durasi", waktu);
					
					durasiTotal += distance.getDouble("value");
					data.put("durasiTotal", HeroHelper.timeConversion(durasiTotal));
					datax.add(data);
					
				}
				
				totalTime = durasiTotal;
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datax;
	}

	public int getTotalTime() {
		return totalTime;
	}
	
	

	
	

}
