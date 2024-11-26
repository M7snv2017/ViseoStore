/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package video.store;

/**
 *
 * @author M7sn9
 */
public class Customer {
    private int customerId;
    private String customerUserName;
    private String customerPassword;
    private String cudtomerPhoneNumber;
    private sOrderViewer[] customerOrders;
    private Video[] favoritesVids;
    private Video[] purchasedVids;


    public Customer(int customerId, String customerUserName, String customerPassword, String cudtomerPhoneNumber, sOrderViewer[] customerOrders, Video[] favoritesVids, Video[] purchasedVids) {
        this.customerId = customerId;
        this.customerUserName = customerUserName;
        this.customerPassword = customerPassword;
        this.cudtomerPhoneNumber = cudtomerPhoneNumber;
        this.customerOrders = customerOrders;
        this.favoritesVids = favoritesVids;
        this.purchasedVids = purchasedVids;
    }

    public int getId(){
        return customerId;
    }

    public void addTofavorites(Video vid){
        // add vid to favoritesVids
    }

    public void addToCart(Video vid){
        // add vid to customerOrders
    }

    public void purchase(Video vid){
        // add vid to purchasedVids
    }

    public Video searchVid(String key){
        // search for key in all videos
        return null;
    }

    public Video[] displayVids() {
        return null;
    }

    public void displayFavorites() {
        // display favoritesVids
    }

    public void updateAccountInfo(String userName, String password, String phoneNumber){
        // update customer info
    }

    public void displayAccountInfo(){
        // display customer info
    }

    public void displayPurchasedVids(){
        // display purchasedVids
    }

    public void displayFavoritesVids(){
        // display favoritesVids
    }

}
