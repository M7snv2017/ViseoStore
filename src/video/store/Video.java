package video.store;

import javax.swing.ImageIcon;

public class Video {

    public int id; //(Mustafa) for ID, a value must be automatically assigned, using sequence for example.
    private int purchaseFrequency, //(Mustafa) Rate replaced. Rating seems to be complext.
            price;
    private String title,
            director,
            synopsis,
            ageGroup, //(Mustafa) upon values, some constraints have to be made (e.g. "newborns" isn't acceptable!)
            genre, //(Mustafa) same as above.
            videoSource,
            year;
    private ImageIcon image;
    CartPage cart;
    public boolean FavoriteFlag,
            cartFlag;

    public Video() {

    }

    public Video(int id, int purchaseFrequency, int price, String title, String director, String synopsis, String ageGroup, String genre, String videoSource, String year, ImageIcon image, CartPage cart) {
        this.id = id;
        this.purchaseFrequency = purchaseFrequency;
        this.price = price;
        this.title = title;
        this.director = director;
        this.synopsis = synopsis;
        this.ageGroup = ageGroup;
        this.genre = genre;
        this.videoSource = videoSource;
        this.year = year;
        this.image = image;
        this.cart = cart;
        this.FavoriteFlag = false;
        this.cartFlag = false;
    }

    public Video(int id, int purchaseFrequency, int price, String ageGroup, String genre, String videoSource, ImageIcon image) {
        this.id = id;
        this.purchaseFrequency = purchaseFrequency;
        this.price = price;
        this.ageGroup = ageGroup;
        this.genre = genre;
        this.videoSource = videoSource;
        this.image = image;
    }

    public Video(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void incrementPurchaseFrequency() {
        this.purchaseFrequency += 1;
    }

    public int getPurchaseFrequency() {
        return purchaseFrequency;
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

    public void setVideoSource(String _videoSource) {
        this.videoSource = _videoSource;
    }

    public String getVideoSource() {
        return this.videoSource;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getTitle() {
        return title;
    }

    public void setDirector(String _director) {
        this.title = _director;
    }

    public String getDirector() {
        return director;
    }

    public void setSynopsis(String _synopsis) {
        this.synopsis = _synopsis;
    }

    public String getSynopsis() {
        return synopsis;
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
