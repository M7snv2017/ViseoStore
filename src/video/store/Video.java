
package video.store;

import javax.swing.ImageIcon;

public class Video
{
   int id,   //(Mustafa) for ID, a value must be automatically assigned, using sequence for example.
       rate, //(Mustafa) some constraints have to be made to prevent values out of [0 - 10] range.
       price;
   String title,
          ageGroup, //(Mustafa) upon values, some constraints have to be made (e.g. "newborns" isn't acceptable!)
          genre, //(Mustafa) same as above.
          videoSource,
          year;
   ImageIcon image;

    public Video()
    {
    }

    public Video(int id, int rate, int price, String ageGroup, String genre, String videoSource, ImageIcon image) {
        this.id = id;
        this.rate = rate;
        this.price = price;
        this.ageGroup = ageGroup;
        this.genre = genre;
        this.videoSource = videoSource;
        this.image = image;
    }
    
    public void setRate(int _rate) {
        if((0<=_rate)&&(_rate<=10))
            this.rate = _rate;
    }
    
    public int getRate() {
        return rate;
    }
    
    /*(Mustafa)  
    public void setGenre(String _genre) {
        for(String i: AcceptableGenres_array){
            if (_genre.equalsIgnoreCase(i))
                this.Genere = _genre;
    }*/
    
    public String getGenre() {
        return genre;
    }
    
    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getTitle() {
        return title;
    }

    public void setAgeGroup(String _ageGroup) {
        this.ageGroup = _ageGroup;
    }
    
    public String getAgeGroup() {
        return ageGroup;
    }
    
    public void setYear(String _year) {
        this.year = _year;
    }
    
    public String getYear() {
        return year;
    }
    
    
    public void setImage(ImageIcon _image) {
        this.image = _image;
    }
    
    public ImageIcon getImage() {
        return image;
    }
   
    public void setPrice(int _price) {
        this.price = _price;
    }
    
    public int getPrice() {
        return price;
    }
    
    


}
