package position;


import java.time.LocalDateTime;

public class BuyPosition extends Position {


    /// Attributes



    /// Methods

    // Pozíció létrehozása / nyitása
    public BuyPosition(LocalDateTime date, double lot, double price) {
        super(date, lot, price);
        this.setType("Buy");
    }


    // Pozíció frissítése
    @Override
    public void updatePosition(LocalDateTime date, double currentPrice) {
        // Nyitott pozícióról beszélünk?
        if(!this.isOpen)
            return;

        this.values.put(date, (this.lotSize * 100000) * (currentPrice - this.openPrice));


    }


}
