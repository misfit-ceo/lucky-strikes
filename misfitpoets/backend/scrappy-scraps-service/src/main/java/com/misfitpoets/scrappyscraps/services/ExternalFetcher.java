package com.misfitpoets.scrappyscraps.services;

import com.misfitpoets.scrappyscraps.domain.ScrapEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExternalFetcher {

    /**
     * Demo method that fetches a web page and extracts some "scrap" data.
     * In reality, you might parse an RSS feed, or read JSON from a REST API, etc.
     */
    public List<ScrapEntry> fetchDataFromSource(String url) {
        List<ScrapEntry> result = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            // Example: Grab all <h2> elements or something
            doc.select("h2").forEach(element -> {
                ScrapEntry e = new ScrapEntry();
                e.setTitle(element.text());
                e.setSummary("Found on page h2 element");
                e.setSourceUrl(url);
                e.setCategory("WEB_SCRAPE");
                e.setExternalId(null);
                result.add(e);
            });
        } catch (Exception e) {
            // Log or handle error
        }
        return result;
    }
}
