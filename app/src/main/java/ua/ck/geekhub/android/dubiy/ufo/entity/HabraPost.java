package ua.ck.geekhub.android.dubiy.ufo.entity;

/**
 * Created by Gary on 08.11.2014.
 */
public class HabraPost {
    public String Title;
    public String Link;
    public String PublishDate;
    public String ShortContent;
    public String Content;

    public HabraPost() {
        this.Title = "ttl";
        this.Link = "lnk";
        this.PublishDate= "pblshDt";
        this.ShortContent = "shrtCntnt";
        this.Content = "cntnt";
    }

    @Override
    public String toString() {
        return Title;
    }
}
