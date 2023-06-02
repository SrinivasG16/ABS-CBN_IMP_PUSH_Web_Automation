package com.applicationpages;

import com.applicationobjects.SearchPageOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage extends GenericMethods {

    private static SearchPageOR searchPageOR;
    private static SearchPage searchPage;


    // Private constructor for the SearchPage class
    private SearchPage() {
        System.out.println("Creating object for Search Page");
    }

    // Static method to get an instance of the SearchPage
    public static SearchPage getInstance() {
        searchPage = null;

        // Check if the searchPage instance is null
        if (searchPage == null) {
            searchPage = new SearchPage();
            searchPageOR = PageFactory.initElements(driver, SearchPageOR.class);
        }

        // Return the searchPage instance
        return searchPage;
    }

    // Verify the presence of the Push logo on the Search Page
    public void Verify_push_logo() {
        availableImage("Search Page", "Push logo", "Push Logo", searchPageOR.img_push_logo);
    }

    // Verify the presence of the Fresh scoops header link on the Search Page
    public void Verify_hdr_freshscoops() {
        availableElement("Search Page", "Header links", "Fresh scoops header link", searchPageOR.lnk_hdr_fresh);
    }

    // Verify the presence of the Photos header link on the Search Page
    public void Verify_hdr_photos() {
        availableElement("Search Page", "Header links", "Photos header link", searchPageOR.lnk_hdr_photos);
    }

    // Verify the presence of the Videos header link on the Search Page
    public void Verify_hdr_videos() {
        availableElement("Search Page", "Header links", "Videos header link", searchPageOR.lnk_hdr_videos);
    }

    // Verify the presence of the Push Awards header link on the Search Page
    public void Verify_hdr_pushawards() {
        availableElement("Search Page", "Header links", "Push Awards header link", searchPageOR.img_push_awards);
    }

    // Verify the presence of the Search text box on the Search Page
    public void Verify_Search() {
        availableElement("Home", "Search", "Search text box", searchPageOR.inp_search);
    }

    // Verify the presence of the Search icon on the Search Page
    public void Verify_Search_icon() {
        availableElement("Home", "Search", "Search icon", searchPageOR.icn_search);
    }

    // Verify the presence of the video article thumbnail in the video section of the Search Page
    public void Verify_video_sec_thumb() throws InterruptedException {
        Thread.sleep(2000);
        clickElement("Search Page", "first slide", searchPageOR.dot_slider);
        availableImage("Search Page", "Video section", "video article thumbnail", searchPageOR.img_video_slider_thumb);
    }

    // Verify the presence of the Latest Photos section on the Search Page
    public void Verify_latpho_section() {
        availableElement("Search Page", "Latest Photos", "Latest Photos Sub section", searchPageOR.txt_latest_sec);
    }

    // Verify the presence of the Latest Photos article thumbnail on the Search Page
    public void Verify_latpho_art_thumb() {
        availableImage("Search Page", "Latest Photos", "Latest Photos Article with thumbnail", searchPageOR.img_latest_thumb);
    }

    // Verify the presence of the Latest Photos article on the Search Page
    public void Verify_latpho_art() {
        availableElement("Search Page", "Latest Photos", "Latest Photos Article", searchPageOR.lnk_latest_art);
    }

    // Verify the presence of the Trending section on the Search Page
    public void Verify_trendnow_section() {
        availableElement("Search Page", "Trending", "Trending Sub section", searchPageOR.txt_trending_sec);
    }

    // Verify the presence of the Trending article on the Search Page
    public void Verify_trendnow_art() {
        availableElement("Search Page", "Trending", "Trending Article", searchPageOR.lnk_trend_art);
    }

    // Verify the presence of the "Terms" footer link on the Search Page
    public void Verify_ftr_terms() {
        availableElement("Search Page", "Footer links", "Terms footer link", searchPageOR.lnk_ftr_terms);
    }

    // Verify the presence of the "Privacy" footer link on the Search Page
    public void Verify_ftr_privacy() {
        availableElement("Search Page", "Footer links", "Privacy footer link", searchPageOR.lnk_ftr_privacy);
    }

    // Verify the presence of the "Contact us" footer link on the Search Page
    public void Verify_ftr_contactUs() {
        availableElement("Search Page", "Footer links", "Contact us footer link", searchPageOR.lnk_ftr_contact);
    }

    // Verify the presence of the "Advertise with us" footer link on the Search Page
    public void Verify_ftr_advtUs() {
        availableElement("Search Page", "Footer links", "Advertise with us footer link", searchPageOR.lnk_ftr_advus);
    }

    // Verify the presence of the "Facebook follow" footer link on the Search Page
    public void Verify_ftr_fbfollow() {
        availableElement("Search Page", "Footer links", "Facebook follow footer link", searchPageOR.icn_fb_flw);
    }

    // Verify the presence of the "Instagram follow" footer link on the Search Page
    public void Verify_ftr_instafollow() {
        availableElement("Search Page", "Footer links", "Instagram follow footer link", searchPageOR.icn_ig_flw);
    }

    // Verify the presence of the "Twitter follow" footer link on the Search Page
    public void Verify_ftr_twfollow() {
        availableElement("Search Page", "Footer links", "Twitter follow footer link", searchPageOR.icn_tw_flw);
    }

    // Verify the presence of the "YouTube follow" footer link on the Search Page
    public void Verify_ftr_ytfollow() {
        availableElement("Search Page", "Footer links", "YouTube follow footer link", searchPageOR.icn_yt_flw);
    }

    // Verify the presence of the "Copy right year" text in the footer on the Search Page
    public void Verify_ftr_copyright() {
        availableElement("Search Page", "Footer", "Copy right year", searchPageOR.txt_copyright);
    }

    // Verify the search results count for a valid search text
    public void Verify_Searchresults() throws InterruptedException {
        Thread.sleep(3000);
        String countResults = searchPageOR.txt_count_results.getText();
        String count = countResults.replaceAll("[^0-9]", "");
        System.out.println("countResults: " + countResults);
        System.out.println("Value is: " + count);

        if (count.equals("")) {
            System.out.println("No results found for input search text");
        } else {
            int actCount = 0;
            int expCount = Integer.parseInt(count);
            System.out.println("Expected count: " + expCount);
            System.out.println("Size is: " + searchPageOR.lst_indCount.size());
            for (int i = 0; i < searchPageOR.lst_indCount.size(); i++) {
                actCount = actCount + Integer.parseInt(searchPageOR.lst_indCount.get(i).getText());
                System.out.println("Count is: " + actCount);
            }

            System.out.println("Actual count is: " + actCount);
            if (actCount == expCount) {
                System.out.println("Search results count matched with the section wise count");
            } else {
                Assert.assertEquals(actCount, expCount, "Search results count not matched with the section wise count");
            }
        }
    }

    // Verify the search functionality for invalid keywords and check for "No Results Found" message
    public void Verify_Searchresults_invalid() {
        String actText = searchPageOR.txt_noresult.getText();
        String expText = "No Results Found";
        if (actText.equals(expText)) {
            System.out.println("Search functionality working as expected for invalid keywords");
        } else {
            Assert.assertEquals(actText, expText, "Search functionality not working as expected for invalid keywords");
        }
    }

}
