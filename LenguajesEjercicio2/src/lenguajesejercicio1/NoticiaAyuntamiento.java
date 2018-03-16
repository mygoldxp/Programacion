/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajesejercicio1;

/**
 *
 * @author v6222
 */
public class NoticiaAyuntamiento {
    
    String title, link, pubDate, guid, creator, date, source;

    public NoticiaAyuntamiento() {
    }

    public NoticiaAyuntamiento(String title, String link, String pubDate, String guid, String creator, String date, String source) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.guid = guid;
        this.creator = creator;
        this.date = date;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "NoticiaAyuntamiento{" + "title=" + title + ", link=" + link + ", pubDate=" + pubDate + ", guid=" + guid + ", creator=" + creator + ", date=" + date + ", source=" + source + '}';
    }
    
    
    
}
