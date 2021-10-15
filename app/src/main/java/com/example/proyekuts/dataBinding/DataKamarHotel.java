package com.example.proyekuts.dataBinding;

import java.util.ArrayList;

public class DataKamarHotel {
    public ArrayList<DataHotel> Room;

    public DataKamarHotel(){
        Room = new ArrayList();
        Room.add(Standar);
        Room.add(Suite);
        Room.add(Single);
        Room.add(Deluxe);
    }

    public static final DataHotel Standar       = new DataHotel("Standar Room","Fasilitas 1", "Fasilitas 2", "Fasilitas 3", "For 1 Night, Inculde Task", 1000000,"https://www.kokoonhotelsvillas.com/surabaya/wp-content/uploads/sites/2/2020/01/standard-room.jpg");
    public static final DataHotel Suite       = new DataHotel("Suite Room","Fasilitas 1", "Fasilitas 2", "Fasilitas 3", "For 1 Night, Inculde Task", 1000000,"https://avenzelhotel.com/wp-content/uploads/2016/03/suite-bedroom-king.jpg");
    public static final DataHotel Single        = new DataHotel("Single Room","Fasilitas 1", "Fasilitas 2", "Fasilitas 3", "For 1 Night, Inculde Task", 1000000,"https://pix10.agoda.net/hotelImages/554/5547527/5547527_18080111100067219956.png?s=1024x768");
    public static final DataHotel Deluxe        = new DataHotel("Deluxe Room","Fasilitas 1", "Fasilitas 2", "Fasilitas 3", "For 1 Night, Inculde Task", 1000000,"https://c4.wallpaperflare.com/wallpaper/844/53/319/miami-florida-hotel-room-wallpaper-preview.jpg");
}
