package com.applicationpages;

import com.applicationobjects.SearchPageOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage extends GenericMethods {

    private static SearchPageOR searchPageOR;
    private static SearchPage searchPage;



    private SearchPage() {
        System.out.println("Creating objecting for Search PAGE");
    }

    public static SearchPage getInstance() {
        searchPage=null;
        if (searchPage == null) {
            searchPage = new SearchPage();
            searchPageOR = PageFactory.initElements(driver, SearchPageOR.class);
        }
        return searchPage;
    }

    public void Verify_push_logo(){

        availableElement("Search Page","Push logo","Push Logo",searchPageOR.img_push_logo);
    }


    public void Verify_hdr_freshscoops(){
        availableElement("Search Page","Header links","Fresh scoops header link",searchPageOR.lnk_hdr_fresh);
    }
    public void Verify_hdr_photos(){
        availableElement("Search Page","Header links","Photos header link",searchPageOR.lnk_hdr_photos);
    }
    public void Verify_hdr_videos(){
        availableElement("Search Page","Header links","Videos header link",searchPageOR.lnk_hdr_videos);
    }

    public void Verify_hdr_pushawards(){
        availableElement("Search Page","Header links","Push Awards header link",searchPageOR.img_push_awards);
    }

    public void Verify_Search() {
        availableElement("Home", "Search", "Search text box", searchPageOR.inp_search);
    }

    public void Verify_Search_icon() {
        availableElement("Home", "Search", "Search text box", searchPageOR.icn_search);
    }

    public void Verify_video_sec_thumb() throws InterruptedException {
        Thread.sleep(2000);
        clickElement("Search Page","first slide",searchPageOR.dot_slider);
        availableElement("Search Page","Video section","video article thumbnail",searchPageOR.img_video_slider_thumb);
    }

    public void Verify_latpho_section(){
        availableElement("Search Page","Latest Photos","Latest Photos Sub section",searchPageOR.txt_latest_sec);
    }
    public void Verify_latpho_art_thumb(){
        availableElement("Search Page","Latest Photos","Latest Photos Article with thumbnail",searchPageOR.img_latest_thumb);
    }
    public void Verify_latpho_art(){
        availableElement("Search Page","Latest Photos","Latest Photos Article",searchPageOR.lnk_latest_art);
    }

    public void Verify_trendnow_section(){
        availableElement("Search Page","Trending ","Trending Sub section",searchPageOR.txt_trending_sec);
    }
    public void Verify_trendnow_art(){
        availableElement("Search Page","Trending ","Trending Article",searchPageOR.lnk_trend_art);
    }

    public void Verify_ftr_terms(){
        availableElement("Search Page","Footer links","terms footer link",searchPageOR.lnk_ftr_terms);
    }

    public void Verify_ftr_privacy(){
        availableElement("Search Page","Footer links","Privacy footer link",searchPageOR.lnk_ftr_privacy);
    }

    public void Verify_ftr_contactUs(){
        availableElement("Search Page","Footer links","Contact us footer link",searchPageOR.lnk_ftr_contact);
    }

    public void Verify_ftr_advtUs(){
        availableElement("Search Page","Footer links","Advertise with us footer link",searchPageOR.lnk_ftr_advus);
    }

    public void Verify_ftr_fbfollow(){
        availableElement("Search Page","Footer links","Facebook follow footer link",searchPageOR.icn_fb_flw);
    }

    public void Verify_ftr_instafollow(){
        availableElement("Search Page","Footer links","Instagram follow footer link",searchPageOR.icn_ig_flw);
    }

    public void Verify_ftr_twfollow(){
        availableElement("Search Page","Footer links","Twitter follow footer link",searchPageOR.icn_tw_flw);
    }

    public void Verify_ftr_ytfollow(){
        availableElement("Search Page","Footer links","Yotube follow footer link",searchPageOR.icn_yt_flw);
    }

    public void Verify_ftr_copyright(){
        availableElement("Search Page","Footer ","Copy right year",searchPageOR.txt_copyright);
    }

    public void Verify_Searchresults() throws InterruptedException {
        Thread.sleep(3000);
    String countResults= searchPageOR.txt_count_results.getText();
    String count=countResults.replaceAll("[^0-9]", "");
        System.out.println("countResults : "+countResults);
        System.out.println("Value is : "+count);

    if(count.equals("")){
        System.out.println("No results found for input search text");
         }else{
        int actCount=0;
        int expCount=Integer.parseInt(count);
        System.out.println("Expected count: "+expCount);
        System.out.println("Size is : "+searchPageOR.lst_indCount.size());
        for(int i=0;i<searchPageOR.lst_indCount.size();i++){

            actCount=actCount+Integer.parseInt(searchPageOR.lst_indCount.get(i).getText());
            System.out.println("Count is : "+actCount);
        }

        System.out.println("actual count is : "+actCount);
        if(actCount==expCount){
            System.out.println("Search results count matched with the section wise count");
        }else{
            Assert.assertEquals(actCount,expCount,"Search results count not matched with the section wise count");
        }

     }
    }
    public void Verify_Searchresults_invalid() {
        String actText = searchPageOR.txt_noresult.getText();
        String expText = "No Results Found";
        if (actText.equals(expText)) {
            System.out.println("Search functionality working as expected for invalid keywords");
        } else {
            Assert.assertEquals(actText, expText, "Search functionality not working as expected for invalid keywords ");
        }
    }
}
