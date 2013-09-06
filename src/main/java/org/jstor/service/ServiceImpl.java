package org.jstor.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.jstor.domain.DataType;
import org.jstor.domain.Dwml;
import org.jstor.domain.HeadType;
import org.jstor.domain.ParametersType;
import org.jstor.domain.ProductType;
import org.jstor.domain.SourceType;
import org.jstor.domain.TempValType;
import org.jstor.domain.WeatherData;
import org.jstor.domain.WeatherLocation;
import org.jstor.domain.WeatherReport;
import org.jstor.domain.ParametersType.Temperature;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements Services {

	@Override
	public WeatherReport getWeatherForNextSevenDays(List<String> zips) {
		WeatherReport wr = new WeatherReport();
		try {
			List<WeatherLocation> list = new ArrayList<WeatherLocation>();

			String transID = UUID.randomUUID().toString();
			RestTemplate rest = new RestTemplate();

			SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) rest
					.getRequestFactory();
			rf.setReadTimeout(1 * 30000);
			rf.setConnectTimeout(1 * 30000);
			rest.setRequestFactory(rf);

			DateTime now = new DateTime();
			DateTime sevenDays = now.plusDays(7);
			String time = "T00:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String tmp = "http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdXMLclient.php?zipCodeList=";
			String d1 = sdf.format(now.toDate());
			String tmp2 = "&product=time-series&begin=";
			String d2 = sdf.format(sevenDays.toDate());

			DateTime[] dates = new DateTime[7];
			dates[0] = now;
			dates[1] = now.plusDays(1);
			dates[2] = now.plusDays(2);
			dates[3] = now.plusDays(3);
			dates[4] = now.plusDays(4);
			dates[5] = now.plusDays(5);
			dates[6] = now.plusDays(6);
			
			/*
			 * String codes=""; if(zips!=null){ int len=zips.size(); int i=1;
			 * for(String str : zips){ codes=codes+str; if(i<len) codes+="+";
			 * i++; }
			 * 
			 * }
			 */

			for (String zip : zips) {

				String query = tmp + zip + tmp2 + d1 + time + "&end=" + d2
						+ time + "&maxt=maxt&mint=mint";
				System.out.println("query: " + query);
				Dwml dwml = null;

				try {
					dwml = rest.getForObject(query, Dwml.class);
				} catch (RestClientException ex) {
					System.out.println("REST Exp: " + ex.toString());
				}

				List<DataType> data = dwml.getData();
				HeadType ht = dwml.getHead();

				String version = dwml.getVersion();

				ProductType ptype = ht.getProduct();
				SourceType st = ht.getSource();
				System.out.println("ProductType:" + ptype.getTitle() + " "
						+ ptype.getConciseName() + " SourceType:"
						+ st.getCredit() + " data size:" + data.size());

				wr.setSource(st.getCredit());
				wr.setTitle(ptype.getTitle());
				wr.setVersion(version);
				int cnt = 0;

				for (DataType dt : data) {

					List<ParametersType> pt = dt.getParameters();

					System.out.println("paramater type size: " + pt.size());
					for (ParametersType p : pt) {

						WeatherLocation wl = new WeatherLocation();
						wl.setZipCode((String) zips.get(cnt));
						List<Temperature> tmps = p.getTemperature();
						System.out.println("temps size:" + tmps.size());
						boolean lows = false;

						List<WeatherData> wdata = new ArrayList<WeatherData>();

						for (int i = 0; i < 7; i++) {
							WeatherData wd = new WeatherData();
							wd.setDate(dates[i].toDate());
							wdata.add(wd);
						}

						wl.setWeatherData(wdata);

						for (Temperature t : tmps) {
							List<TempValType> tv = t.getValue();
							String name = t.getName();
							String units = t.getUnits();
							String timelayout = t.getTimeLayout();

							System.out.println("Name:" + name + " size: "
									+ tv.size() + " units:" + units
									+ " timelayout:" + timelayout);
							int dayCnt = 0;
							for (TempValType o : tv) {
								BigInteger bi = o.getValue();
								System.out.println("temp:" + bi);

								if (lows == true)
									wl.getWeatherData().get(dayCnt).setLow(bi);
								else
									wl.getWeatherData().get(dayCnt).setHigh(bi);

								dayCnt++;
							}
							lows = true;
						}
						list.add(wl);
					}
				}
			}
			wr.setLocations(list);
		} catch (Exception ex) {
			System.out.println("********EXCEPTION************" + ex.toString());
		}
		return wr;
	}

}
