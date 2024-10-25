
package video.store;

import javax.swing.ImageIcon;

public class Video 
{
   int id,
       Rate,
       price;
   String ageGroup,
          genere,
          videoSource;
   ImageIcon image;

    public Video() 
    {
    }

    public Video(int id, int Rate, int price, String ageGroup, String genere, String videoSource, ImageIcon image) {
        this.id = id;
        this.Rate = Rate;
        this.price = price;
        this.ageGroup = ageGroup;
        this.genere = genere;
        this.videoSource = videoSource;
        this.image = image;
    }
    
    
   
}
