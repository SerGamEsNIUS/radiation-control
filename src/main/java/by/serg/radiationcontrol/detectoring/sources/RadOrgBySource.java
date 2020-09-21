package by.serg.radiationcontrol.detectoring.sources;

import by.serg.radiationcontrol.detectoring.bean.Detector;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Data
@Component
@Qualifier("Source")
public class RadOrgBySource implements Source {
    public static final String URL = "http://rad.org.by/radiation.xml";

    @Override
    public void readSourceAndUpdateDetectors(Set<Detector> detectors) {
        try {
            Elements listElements = Jsoup.connect(URL).get().body()
                    .select("item");
            for (Element element: listElements) {
                String location = element.selectFirst("title").ownText();
                Double activity = Double.valueOf(element.selectFirst("rad").ownText());
                Date dateTime = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z")
                        .parse(element.selectFirst("pubDate").ownText());
                detectors.add(
                        Detector.builder().location(location)
                                .activity(activity).dateTime(dateTime).build()
                );
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


}
