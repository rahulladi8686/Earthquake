package android.example.pleaseworkthistime;

public class Earthquake {
   private String mTime;
   private String mDate;
   private String mPlace;
   private double mMag;
   private String mUrl;

   Earthquake(double mag , String place , String time , String date , String url)
   {
       mMag = mag;
       mPlace = place;
       mTime = time;
       mDate = date;
       mUrl  =url;
   }

   public String getTime() {
       return mTime;
   }

   public String getDate(){
       return mDate;
   }

   public double getMag() {
       return mMag;
   }

   public String getPlace() {
       return mPlace;
   }

   public String getUrl(){return mUrl;}
}
